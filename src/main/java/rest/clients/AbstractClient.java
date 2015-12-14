package rest.clients;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import configuration.AppProperties;

public abstract class AbstractClient<T>{
	protected WebResource target;
	protected Client client;
	protected static final String BASE_URI = AppProperties.getInstance().getProperty("base_uri");
	protected Class<T> entityClass;
	protected String entityName;
	public AbstractClient(Class<T> entityClass) {
		this.entityClass = entityClass;
		this.entityName = entityClass.getSimpleName();
		this.client = Client.create();
		this.target = client.resource(BASE_URI).path(entityName);
	}
	public T find(long id){
		WebResource res = target.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(entityClass);
	}
	public List<T> findAll(){
		WebResource res = target;
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<T>>(){});
	}
	public void create(T entity){
		//check this out when connected
		//find out how to add content-type to the header
		WebResource res = target;
		res.post(entity);
	}
	public void update(T entity,long id){
		//check this one too
		WebResource res = target.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
		res.put(entity);
	}
	public void remove(long id){
		WebResource res = target.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
		res.delete();
	}
}
