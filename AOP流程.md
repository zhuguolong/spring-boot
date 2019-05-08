
- DefaultSingletonBeanRegistry.addSingleton() {
      synchronized (this.singletonObjects) {
          this.singletonObjects.put(beanName, singletonObject);
      }
  }

- ApplicationContext.getBean(MathServiceImpl.class)  
  - AbstractApplicationContext.getBean()
    - getBeanFactory().getBean(requiredType)  
      - DefaultListableBeanFactory.resolveBean(ResolvableType.forRawClass(requiredType), args, false)
        - DefaultListableBeanFactory.resolveNamedBean(requiredType, args, nonUniqueAsNull)
          - AbstractBeanFactory.getBean()
            - AbstractBeanFactory.doGetBean()
              - DefaultSingletonBeanRegistry.getSingleton()
                - DefaultSingletonBeanRegistry.getSingleton()