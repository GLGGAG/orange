package com.orange.framework.aop;

/**
 * @author : GLGGAG
 * @since : 2017/11/16
 *
 *
 * 在使用面对对象编程（OOP）有一些弊端，当需要为多个不具有继承关系的对象引入同一个公共行为时，如日志，安全监测等，我们只有在每个对象里引用公共行为，这样程序
 * 就会产生大量重复代码，程序不便于维护，所以有一个面对对象编程的补充，即面向方向编程（AOP），AOP关注的的方向是横向，不同于OOP的纵向
 *
 * ---------------->@see ./AOPMain 试着运行main方法
 * 看到效果了以后，那么Spring是如何实现AOP的呢？首先知道，Spring是否支持注解的AOP是由一个配置文件控制的，也就是<aop:apsectj-autoproxy/>,当配置文件中声明了这句配置的时候，
 * spring就会支持注解的AOP，那么我们来分析从这句注解开始
 *<aop:apsectj-autoproxy/> 属于自定义注解器，spring对自定注解的支持，那么会在程序的想要地方注册了对应的解析器，@see AopNamespaceHandler
 * 此类中我们得知解析"aspectj-autoproxy"是由AspectJAutoProxyBeanDefinitionParser类处理
 * 在spring中，所有的解析器都是对BeanDefinitionParser接口统一实现，入口都是parse函数开始
 * AspectJAutoProxyBeanDefinitionParser函数的parse函数如下
 * --------------------------------------------------------------------------------------------------------
 * @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        AopNamespaceUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(parserContext, element);//注册AnnotationAutoProxyCreator
        extendBeanDefinition(element, parserContext);//对注解中子类的处理
        return null;
    }
 * --------------------------------------------------------------------------------------------------------
 * registerAspectJAnnotationAutoProxyCreatorIfNecessary函数如下
 * --------------------------------------------------------------------------------------------------------
 * public static void registerAspectJAnnotationAutoProxyCreatorIfNecessary(
        ParserContext parserContext, Element sourceElement) {

        BeanDefinition beanDefinition = AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(
        parserContext.getRegistry(), parserContext.extractSource(sourceElement));//注册和定义beanDefinition

        useClassProxyingIfNecessary(parserContext.getRegistry(), sourceElement);//对于proxy-target-class以及expose-proxy属性的处理
        registerComponentIfNecessary(beanDefinition, parserContext);//注册组件饼通知，便于监听器做进一步处理
    }
 * ---------------------------------------------------------------------------------------------------------
 * 在这段代码中，分为三步，每一步都是一个完整的逻辑处理，这也是spring代码的风格，功能分成拆简化交由不同的专业的对象处理，我们来看每一个步骤的处理
 * 1.注册或者升级AnnotationAwareAspectJAutoProxyCreator
 * 对于AOP的实现，基本上都是靠AnnotationAwareAspectJAutoProxyCreator去完成，它可以根据@Point注解定义的切点来自代理相匹配的bean，但是为了配置简单，Spring使用了自定义
 * 配置来帮助我们自动注册AnnotationAwareAspectJAutoProxyCreator，其注册过程就是在这里实现
 * ----------------------------------------------------------------------------------------------------------
 *
 *  public static BeanDefinition registerAspectJAnnotationAutoProxyCreatorIfNecessary(BeanDefinitionRegistry registry, Object source) {
        return registerOrEscalateApcAsRequired(AnnotationAwareAspectJAutoProxyCreator.class, registry, source);
    }

    private static BeanDefinition registerOrEscalateApcAsRequired(Class<?> cls, BeanDefinitionRegistry registry, Object source) {
        Assert.notNull(registry, "BeanDefinitionRegistry must not be null");
        if (registry.containsBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME)) { //如果已经存在了自动代理创建器且自动代理创建器与现在不一致那么需要根据优先级来判断到底需要使用哪个
            BeanDefinition apcDefinition = registry.getBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME);
            if (!cls.getName().equals(apcDefinition.getBeanClassName())) {
                int currentPriority = findPriorityForClass(apcDefinition.getBeanClassName());
                int requiredPriority = findPriorityForClass(cls);
                if (currentPriority < requiredPriority) {
                    apcDefinition.setBeanClassName(cls.getName());
                }
            }
        return null;//如果已经存在自动代理创建器了，也与现在一致，那么久不需要重复创建返回null
        }
        //创建一个新的自动代理创建器
        RootBeanDefinition beanDefinition = new RootBeanDefinition(cls);
        beanDefinition.setSource(source);
        beanDefinition.getPropertyValues().add("order", Ordered.HIGHEST_PRECEDENCE);
        beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        registry.registerBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME, beanDefinition);
        return beanDefinition;
    }
 * ----------------------------------------------------------------------------------------------------------
 * 2.处理proxy-target-class 以及expose-proxy属性
 * useClassProxying实现了proxy属性以及expose-proxy属性的处理
 * ----------------------------------------------------------------------------------------------------------
 * private static void useClassProxyingIfNecessary(BeanDefinitionRegistry registry, Element sourceElement) {
    if (sourceElement != null) {
        boolean proxyTargetClass = Boolean.valueOf(sourceElement.getAttribute(PROXY_TARGET_CLASS_ATTRIBUTE));//处理proxy-target-class属性
        if (proxyTargetClass) {
            AopConfigUtils.forceAutoProxyCreatorToUseClassProxying(registry);
        }
        boolean exposeProxy = Boolean.valueOf(sourceElement.getAttribute(EXPOSE_PROXY_ATTRIBUTE));//处理expose-proxy属性
        if (exposeProxy) {
            AopConfigUtils.forceAutoProxyCreatorToExposeProxy(registry);
        }
    }
 }
 * ----------------------------------------------------------------------------------------------------------
 * -->proxy-target-class：Spring AOP部分使用JDK动态代理或者CGLIB来为目标对象创建代理（建议尽量使用JDK动态代理），如果被代理的目标对象实现了至少一个接口，则会使用JDK动态代理
 * 所有该目标类型实现的接口都将被代理，若该对象目标没有实现任何接口，则创建一个CGLIB代理。如果希望强制使用CGLIB代理，那也可以，但是需要考虑如下两个问题
 * ---->无法控制（advise）Final方法，因为他们不能被覆写
 * ---->你需要将CGLIB二进制发行包放在classPath下面
 *
 * 与之比较，JDK本身提供动态代理，强制使用CGLIB代理需要将<aop:aspectj-autoproxy/>的proxy-target-class属性设置为true:
 *           <aop:aspectj-autoproxy proxy-target-class="true"/>
 *
 *  JDK动态代理和CGLIB代理区别
 *  -->JDK动态代理:其代理对象必须是某个接口的实现，它是通过在运行期间创建一个接口的实现类类完成对目标对象的代理
 *  -->CGLIB代理:实现原理雷士JDK动态代理，只是它在运行期间生成的代理对象针对目标类扩展的子类。CGLIB是高效的代码生成包，底层是依靠ASM（开源的JAVA字节码编辑类库）操作字节码实现的，性能比JDK强
 *
 * 3.最后注册组件并通知，便于监听器做进一步的处理
 *
 *
 *
 * AnnotationAwareAspectJAutoProxyCreator实现了BeanPostProcessor，当Spring加载这个Bean时会在实例化前调用其postProcessAfterInitialization方法，对AOP的逻辑分析也由此开始
 * 在父类AbstractAutoProxyCreator的preProcessAfterInitialization中代码如下:
 * -------------------------------------------------------------------------------------------------------------------
 * 	@Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean != null) {
            Object cacheKey = getCacheKey(bean.getClass(), beanName);
            if (!this.earlyProxyReferences.contains(cacheKey)) {//如果适合被代理，则需要封装指定bean
                return wrapIfNecessary(bean, beanName, cacheKey);
            }
        }
        return bean;
    }
    protected Object wrapIfNecessary(Object bean, String beanName, Object cacheKey) {
        if (beanName != null && this.targetSourcedBeans.contains(beanName)) {//已经被处理过，则不再处理
            return bean;
        }
        if (Boolean.FALSE.equals(this.advisedBeans.get(cacheKey))) {
            return bean;
        }
        if (isInfrastructureClass(bean.getClass()) || shouldSkip(bean.getClass(), beanName)) {//如果给定的类属于基础设施类，那么不应被代理或者指定bean不需要自动代理
            this.advisedBeans.put(cacheKey, Boolean.FALSE);
            return bean;
        }

        // Create proxy if we have advice.
        Object[] specificInterceptors = getAdvicesAndAdvisorsForBean(bean.getClass(), beanName, null);
        if (specificInterceptors != DO_NOT_PROXY) {
            this.advisedBeans.put(cacheKey, Boolean.TRUE);
            Object proxy = createProxy(bean.getClass(), beanName, specificInterceptors, new SingletonTargetSource(bean));//创建代理
            this.proxyTypes.put(cacheKey, proxy.getClass());
            return proxy;
        }

        this.advisedBeans.put(cacheKey, Boolean.FALSE);
        return bean;
    }

 * -------------------------------------------------------------------------------------------------------------------
 *
 *
 *
 *
 *
 */
