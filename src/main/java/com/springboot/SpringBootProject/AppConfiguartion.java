package com.springboot.SpringBootProject;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguartion {
	
	//@Value() -- use to read data from properties file.
	@Value("${spring.datasource.username}")
	private String userName;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${common.info}")
	private String info;
	
	@Bean
	public void readDataBaseProperties() {
		System.out.println(userName);
		System.out.println(password);
		System.out.println(info);
	}
		
	
//	@Autowired
//	private PostRepository postRepository;
//	
//	@Autowired
//	private CommentRepository commentRepository;
//	
//	@Autowired
//	private ChannelRepository channelRepository;
//	
//	@Autowired
//	private SubscriberRepository subscriberRepository;
	
	
	/*
	 * 
	 when we excluded auto database configration
	 @SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
`	 to use this when want to wrte own code to connect to db
	
	@Bean
    public DataSource getDataSource() 
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/springboot");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
    
    @Bean annotation is used to let Spring framework know that this method 
    should be used to get the bean implementation to inject in Component classes.
	
	 @Bean
	   public SessionFactory getSessionFactory() {
	     Configuration configuration = new Configuration();
			 	Properties props = new Properties();
	            props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	            props.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/sessiontest");
	            props.put("hibernate.connection.username", "root");
	            props.put("hibernate.connection.password", "pirati23");
	            props.put("hibernate.current_session_context_class", "thread");
	            configuration.setProperties(props);
			
    
           configuration.addAnnotatedClass(Employee.class);

			configuration.configure();
			serviceRegistry = (ServiceRegistry) new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	  }
	
	 in services instead of repository we can use this HibernateTemplate
	 @Autowired
	 private SessionFactory factory;
	 
	 */


	@Bean
	public void preparePostData() {
		
//		BeanFactory b=new XmlBeanFactory(new ClassPathResource("beans.xml"));
//		CustomerService c=(CustomerService)b.getBean("customer");
//		ApplicationContext c=new ClassPathXmlApplicationContext();
		
		System.out.println("app configuation class");
		
		
		
//		Channel c1=new Channel("java");
//		Channel c2=new Channel("springboot");
//		Channel c3=new Channel("hibernate");
//		
//		List<Subscriber> subs1;
//		List<Subscriber> subs2;
//		List<Subscriber> subs3;
//		
//		
//		subs1=new ArrayList<Subscriber>();
//		for(int i=1;i<=10;i++) {
//			Subscriber s=new Subscriber("subscriber : "+i);
//			subscriberRepository.save(s);
//			subs1.add(s);
//		}
//		
//		c1.getSubscribers().addAll(subs1);
//		channelRepository.save(c1);
//		
//		subs2=new ArrayList<Subscriber>();
//		for(int i=11;i<=20;i++) {
//			Subscriber s=new Subscriber("subscriber : "+i);
//			subscriberRepository.save(s);
//			subs2.add(s);
//		}
//		
//		c2.getSubscribers().addAll(subs2);
//		channelRepository.save(c2);
//		
//		
//		subs1=new ArrayList<Subscriber>();
//		for(int i=21;i<=30;i++) {
//			Subscriber s=new Subscriber("subscriber : "+i);
//			subscriberRepository.save(s);
//			subs1.add(s);
//		}
//		
//		c1.getSubscribers().addAll(subs1);
//		channelRepository.save(c1);
//		
//		subs3=new ArrayList<Subscriber>();
//		for(int i=31;i<=40;i++) {
//			Subscriber s=new Subscriber("subscriber : "+i);
//			subscriberRepository.save(s);
//			subs3.add(s);
//		}
//		
//		c3.getSubscribers().addAll(subs3);
//		channelRepository.save(c3);
//		
//		subs1=new ArrayList<Subscriber>();
//		for(int i=41;i<=60;i++) {
//			Subscriber s=new Subscriber("subscriber : "+i);
//			subscriberRepository.save(s);
//			subs1.add(s);
//		}
//		
//		c1.getSubscribers().addAll(subs1);
//		channelRepository.save(c1);
//		
//		subs2=new ArrayList<Subscriber>();
//		for(int i=61;i<=80;i++) {
//			Subscriber s=new Subscriber("subscriber : "+i);
//			subscriberRepository.save(s);
//			subs2.add(s);
//		}
//		
//		c2.getSubscribers().addAll(subs2);
//		channelRepository.save(c2);
//		
//		
//		subs1=new ArrayList<Subscriber>();
//		for(int i=81;i<=90;i++) {
//			Subscriber s=new Subscriber("subscriber : "+i);
//			subscriberRepository.save(s);
//			subs1.add(s);
//		}
//		
//		c1.getSubscribers().addAll(subs1);
//		channelRepository.save(c1);
		
//		for(int i=31;i<=40;i++) {
//			Post p=new Post("post desc"+i);
//			postRepository.save(p);
//		}
//		
//		for(int i=1;i<=10;i++) {
//			Post p=new Post("post desc"+i);
//			postRepository.save(p);
//		}
//		
//		for(int i=41;i<=50;i++) {
//			Post p=new Post("post desc"+i);
//			postRepository.save(p);
//		}
//		for(int i=21;i<=30;i++) {
//			Post p=new Post("post desc"+i);
//			postRepository.save(p);
//		}
//		
//		for(int i=11;i<=20;i++) {
//			Post p=new Post("post desc"+i);
//			postRepository.save(p);
//		}
//		
//		Optional<Post> ispost=postRepository.findById(1);
//		if(ispost.isPresent()) {
//			for(int i=1;i<=500;i++) {
//				Comment c1=new Comment("comment1 : "+i,ispost.get());
//				commentRepository.save(c1);
//			}
//		}
//		
//		Optional<Post> ispost2=postRepository.findById(2);
//		if(ispost2.isPresent()) {
//			for(int i=1;i<=500;i++) {
//				Comment c1=new Comment("comment2 : "+i,ispost2.get());
//				commentRepository.save(c1);
//			}
//		}
//		
		
		
		
		
	}

}
