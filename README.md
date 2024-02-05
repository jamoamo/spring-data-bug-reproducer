## Reproducer for bug in spring-data-jdbc
Bug logged at: https://github.com/spring-projects/spring-data-relational/issues/1734

Running the project results in the following exception
> org.springframework.jdbc.BadSqlGrammarException: PreparedStatementCallback; bad SQL grammar [SELECT "LEAF"."LEAF_REF" AS "LEAF_REF" FROM "LEAF" WHERE "LEAF"."BRANCH_REF" = ?]
	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:103) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:107) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.core.JdbcTemplate.translateException(JdbcTemplate.java:1548) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:677) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:723) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:748) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:804) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate.query(NamedParameterJdbcTemplate.java:218) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.data.jdbc.core.convert.DefaultDataAccessStrategy.findAllByPath(DefaultDataAccessStrategy.java:306) ~[spring-data-jdbc-3.2.2.jar:3.2.2]
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:351) ~[spring-aop-6.1.3.jar:6.1.3]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:213) ~[spring-aop-6.1.3.jar:6.1.3]
	at jdk.proxy2/jdk.proxy2.$Proxy63.findAllByPath(Unknown Source) ~[na:na]
	at org.springframework.data.jdbc.core.convert.MappingJdbcConverter$ResolvingRelationalPropertyValueProvider.getPropertyValue(MappingJdbcConverter.java:379) ~[spring-data-jdbc-3.2.2.jar:3.2.2]
	at org.springframework.data.jdbc.core.convert.MappingJdbcConverter$ResolvingRelationalPropertyValueProvider.getPropertyValue(MappingJdbcConverter.java:310) ~[spring-data-jdbc-3.2.2.jar:3.2.2]
	at org.springframework.data.relational.core.conversion.MappingRelationalConverter.readProperties(MappingRelationalConverter.java:555) ~[spring-data-relational-3.2.2.jar:3.2.2]
	at org.springframework.data.relational.core.conversion.MappingRelationalConverter.populateProperties(MappingRelationalConverter.java:522) ~[spring-data-relational-3.2.2.jar:3.2.2]
	at org.springframework.data.relational.core.conversion.MappingRelationalConverter.read(MappingRelationalConverter.java:456) ~[spring-data-relational-3.2.2.jar:3.2.2]
	at org.springframework.data.relational.core.conversion.MappingRelationalConverter.readAggregate(MappingRelationalConverter.java:348) ~[spring-data-relational-3.2.2.jar:3.2.2]
	at org.springframework.data.jdbc.core.convert.MappingJdbcConverter.access$000(MappingJdbcConverter.java:68) ~[spring-data-jdbc-3.2.2.jar:3.2.2]
	at org.springframework.data.jdbc.core.convert.MappingJdbcConverter$ResolvingRelationalPropertyValueProvider.getPropertyValue(MappingJdbcConverter.java:398) ~[spring-data-jdbc-3.2.2.jar:3.2.2]
	at org.springframework.data.jdbc.core.convert.MappingJdbcConverter$ResolvingRelationalPropertyValueProvider.getPropertyValue(MappingJdbcConverter.java:310) ~[spring-data-jdbc-3.2.2.jar:3.2.2]
	at org.springframework.data.relational.core.conversion.MappingRelationalConverter.readProperties(MappingRelationalConverter.java:555) ~[spring-data-relational-3.2.2.jar:3.2.2]
	at org.springframework.data.relational.core.conversion.MappingRelationalConverter.populateProperties(MappingRelationalConverter.java:522) ~[spring-data-relational-3.2.2.jar:3.2.2]
	at org.springframework.data.relational.core.conversion.MappingRelationalConverter.read(MappingRelationalConverter.java:456) ~[spring-data-relational-3.2.2.jar:3.2.2]
	at org.springframework.data.relational.core.conversion.MappingRelationalConverter.readAggregate(MappingRelationalConverter.java:348) ~[spring-data-relational-3.2.2.jar:3.2.2]
	at org.springframework.data.relational.core.conversion.MappingRelationalConverter.readAggregate(MappingRelationalConverter.java:311) ~[spring-data-relational-3.2.2.jar:3.2.2]
	at org.springframework.data.jdbc.core.convert.MappingJdbcConverter.readAndResolve(MappingJdbcConverter.java:287) ~[spring-data-jdbc-3.2.2.jar:3.2.2]
	at org.springframework.data.jdbc.core.convert.JdbcConverter.readAndResolve(JdbcConverter.java:106) ~[spring-data-jdbc-3.2.2.jar:3.2.2]
	at org.springframework.data.jdbc.core.convert.EntityRowMapper.mapRow(EntityRowMapper.java:82) ~[spring-data-jdbc-3.2.2.jar:3.2.2]
	at org.springframework.jdbc.core.RowMapperResultSetExtractor.extractData(RowMapperResultSetExtractor.java:94) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.core.RowMapperResultSetExtractor.extractData(RowMapperResultSetExtractor.java:61) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.core.JdbcTemplate$1.doInPreparedStatement(JdbcTemplate.java:733) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:658) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:723) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:748) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:804) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate.query(NamedParameterJdbcTemplate.java:218) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate.query(NamedParameterJdbcTemplate.java:230) ~[spring-jdbc-6.1.3.jar:6.1.3]
	at org.springframework.data.jdbc.core.convert.DefaultDataAccessStrategy.findAll(DefaultDataAccessStrategy.java:276) ~[spring-data-jdbc-3.2.2.jar:3.2.2]
	at org.springframework.data.jdbc.core.JdbcAggregateTemplate.findAll(JdbcAggregateTemplate.java:341) ~[spring-data-jdbc-3.2.2.jar:3.2.2]
	at org.springframework.data.jdbc.repository.support.SimpleJdbcRepository.findAll(SimpleJdbcRepository.java:89) ~[spring-data-jdbc-3.2.2.jar:3.2.2]
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:351) ~[spring-aop-6.1.3.jar:6.1.3]
	at org.springframework.data.repository.core.support.RepositoryMethodInvoker$RepositoryFragmentMethodInvoker.lambda$new$0(RepositoryMethodInvoker.java:277) ~[spring-data-commons-3.2.2.jar:3.2.2]
	at org.springframework.data.repository.core.support.RepositoryMethodInvoker.doInvoke(RepositoryMethodInvoker.java:170) ~[spring-data-commons-3.2.2.jar:3.2.2]
	at org.springframework.data.repository.core.support.RepositoryMethodInvoker.invoke(RepositoryMethodInvoker.java:158) ~[spring-data-commons-3.2.2.jar:3.2.2]
	at org.springframework.data.repository.core.support.RepositoryComposition$RepositoryFragments.invoke(RepositoryComposition.java:516) ~[spring-data-commons-3.2.2.jar:3.2.2]
	at org.springframework.data.repository.core.support.RepositoryComposition.invoke(RepositoryComposition.java:285) ~[spring-data-commons-3.2.2.jar:3.2.2]
	at org.springframework.data.repository.core.support.RepositoryFactorySupport$ImplementationMethodExecutionInterceptor.invoke(RepositoryFactorySupport.java:628) ~[spring-data-commons-3.2.2.jar:3.2.2]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[spring-aop-6.1.3.jar:6.1.3]
	at org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.doInvoke(QueryExecutorMethodInterceptor.java:168) ~[spring-data-commons-3.2.2.jar:3.2.2]
	at org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.invoke(QueryExecutorMethodInterceptor.java:143) ~[spring-data-commons-3.2.2.jar:3.2.2]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[spring-aop-6.1.3.jar:6.1.3]
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:123) ~[spring-tx-6.1.3.jar:6.1.3]
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:385) ~[spring-tx-6.1.3.jar:6.1.3]
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119) ~[spring-tx-6.1.3.jar:6.1.3]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[spring-aop-6.1.3.jar:6.1.3]
	at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:137) ~[spring-tx-6.1.3.jar:6.1.3]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[spring-aop-6.1.3.jar:6.1.3]
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97) ~[spring-aop-6.1.3.jar:6.1.3]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[spring-aop-6.1.3.jar:6.1.3]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:220) ~[spring-aop-6.1.3.jar:6.1.3]
	at jdk.proxy2/jdk.proxy2.$Proxy67.findAll(Unknown Source) ~[na:na]
	at spring.test.bugreproduce.BugReproduceApplication.handleContextRefresh(BugReproduceApplication.java:31) ~[classes/:na]
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
	at org.springframework.context.event.ApplicationListenerMethodAdapter.doInvoke(ApplicationListenerMethodAdapter.java:365) ~[spring-context-6.1.3.jar:6.1.3]
	at org.springframework.context.event.ApplicationListenerMethodAdapter.processEvent(ApplicationListenerMethodAdapter.java:237) ~[spring-context-6.1.3.jar:6.1.3]
	at org.springframework.context.event.ApplicationListenerMethodAdapter.onApplicationEvent(ApplicationListenerMethodAdapter.java:168) ~[spring-context-6.1.3.jar:6.1.3]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:178) ~[spring-context-6.1.3.jar:6.1.3]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:171) ~[spring-context-6.1.3.jar:6.1.3]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:149) ~[spring-context-6.1.3.jar:6.1.3]
	at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:451) ~[spring-context-6.1.3.jar:6.1.3]
	at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:384) ~[spring-context-6.1.3.jar:6.1.3]
	at org.springframework.context.support.AbstractApplicationContext.finishRefresh(AbstractApplicationContext.java:981) ~[spring-context-6.1.3.jar:6.1.3]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:627) ~[spring-context-6.1.3.jar:6.1.3]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:754) ~[spring-boot-3.2.2.jar:3.2.2]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:456) ~[spring-boot-3.2.2.jar:3.2.2]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.2.jar:3.2.2]
	at org.springframework.boot.test.context.SpringBootContextLoader.lambda$loadContext$3(SpringBootContextLoader.java:137) ~[spring-boot-test-3.2.2.jar:3.2.2]
	at org.springframework.util.function.ThrowingSupplier.get(ThrowingSupplier.java:58) ~[spring-core-6.1.3.jar:6.1.3]
	at org.springframework.util.function.ThrowingSupplier.get(ThrowingSupplier.java:46) ~[spring-core-6.1.3.jar:6.1.3]
	at org.springframework.boot.SpringApplication.withHook(SpringApplication.java:1454) ~[spring-boot-3.2.2.jar:3.2.2]
	at org.springframework.boot.test.context.SpringBootContextLoader$ContextLoaderHook.run(SpringBootContextLoader.java:552) ~[spring-boot-test-3.2.2.jar:3.2.2]
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:137) ~[spring-boot-test-3.2.2.jar:3.2.2]
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:108) ~[spring-boot-test-3.2.2.jar:3.2.2]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:225) ~[spring-test-6.1.3.jar:6.1.3]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:152) ~[spring-test-6.1.3.jar:6.1.3]
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130) ~[spring-test-6.1.3.jar:6.1.3]
	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.injectDependencies(DependencyInjectionTestExecutionListener.java:142) ~[spring-test-6.1.3.jar:6.1.3]
	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.prepareTestInstance(DependencyInjectionTestExecutionListener.java:98) ~[spring-test-6.1.3.jar:6.1.3]
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:260) ~[spring-test-6.1.3.jar:6.1.3]
	at org.springframework.test.context.junit.jupiter.SpringExtension.postProcessTestInstance(SpringExtension.java:163) ~[spring-test-6.1.3.jar:6.1.3]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$10(ClassBasedTestDescriptor.java:378) ~[junit-jupiter-engine-5.10.1.jar:5.10.1]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.executeAndMaskThrowable(ClassBasedTestDescriptor.java:383) ~[junit-jupiter-engine-5.10.1.jar:5.10.1]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$11(ClassBasedTestDescriptor.java:378) ~[junit-jupiter-engine-5.10.1.jar:5.10.1]
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:179) ~[na:na]
	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1708) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499) ~[na:na]
	at java.base/java.util.stream.StreamSpliterators$WrappingSpliterator.forEachRemaining(StreamSpliterators.java:310) ~[na:na]
	at java.base/java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:735) ~[na:na]
	at java.base/java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:734) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:762) ~[na:na]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.invokeTestInstancePostProcessors(ClassBasedTestDescriptor.java:377) ~[junit-jupiter-engine-5.10.1.jar:5.10.1]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$instantiateAndPostProcessTestInstance$6(ClassBasedTestDescriptor.java:290) ~[junit-jupiter-engine-5.10.1.jar:5.10.1]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.instantiateAndPostProcessTestInstance(ClassBasedTestDescriptor.java:289) ~[junit-jupiter-engine-5.10.1.jar:5.10.1]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$4(ClassBasedTestDescriptor.java:279) ~[junit-jupiter-engine-5.10.1.jar:5.10.1]
	at java.base/java.util.Optional.orElseGet(Optional.java:364) ~[na:na]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$5(ClassBasedTestDescriptor.java:278) ~[junit-jupiter-engine-5.10.1.jar:5.10.1]
	at org.junit.jupiter.engine.execution.TestInstancesProvider.getTestInstances(TestInstancesProvider.java:31) ~[junit-jupiter-engine-5.10.1.jar:5.10.1]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$prepare$0(TestMethodTestDescriptor.java:106) ~[junit-jupiter-engine-5.10.1.jar:5.10.1]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:105) ~[junit-jupiter-engine-5.10.1.jar:5.10.1]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:69) ~[junit-jupiter-engine-5.10.1.jar:5.10.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$prepare$2(NodeTestTask.java:123) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.prepare(NodeTestTask.java:123) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:90) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596) ~[na:na]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:155) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596) ~[na:na]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:155) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:35) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:54) ~[junit-platform-engine-1.10.1.jar:1.10.1]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:198) ~[junit-platform-launcher-1.10.1.jar:1.10.1]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:169) ~[junit-platform-launcher-1.10.1.jar:1.10.1]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:93) ~[junit-platform-launcher-1.10.1.jar:1.10.1]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.lambda$execute$0(EngineExecutionOrchestrator.java:58) ~[junit-platform-launcher-1.10.1.jar:1.10.1]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.withInterceptedStreams(EngineExecutionOrchestrator.java:141) ~[junit-platform-launcher-1.10.1.jar:1.10.1]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:57) ~[junit-platform-launcher-1.10.1.jar:1.10.1]
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:103) ~[junit-platform-launcher-1.10.1.jar:1.10.1]
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:85) ~[junit-platform-launcher-1.10.1.jar:1.10.1]
	at org.junit.platform.launcher.core.DelegatingLauncher.execute(DelegatingLauncher.java:47) ~[junit-platform-launcher-1.10.1.jar:1.10.1]
	at org.apache.maven.surefire.junitplatform.LazyLauncher.execute(LazyLauncher.java:56) ~[surefire-junit-platform-3.1.2.jar:3.1.2]
	at org.apache.maven.surefire.junitplatform.JUnitPlatformProvider.execute(JUnitPlatformProvider.java:184) ~[surefire-junit-platform-3.1.2.jar:3.1.2]
	at org.apache.maven.surefire.junitplatform.JUnitPlatformProvider.invokeAllTests(JUnitPlatformProvider.java:148) ~[surefire-junit-platform-3.1.2.jar:3.1.2]
	at org.apache.maven.surefire.junitplatform.JUnitPlatformProvider.invoke(JUnitPlatformProvider.java:122) ~[surefire-junit-platform-3.1.2.jar:3.1.2]
	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:385) ~[surefire-booter-3.1.2.jar:3.1.2]
	at org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:162) ~[surefire-booter-3.1.2.jar:3.1.2]
	at org.apache.maven.surefire.booter.ForkedBooter.run(ForkedBooter.java:507) ~[surefire-booter-3.1.2.jar:3.1.2]
	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:495) ~[surefire-booter-3.1.2.jar:3.1.2]
