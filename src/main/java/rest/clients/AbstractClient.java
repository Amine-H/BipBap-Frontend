package rest.clients;

import java.util.List;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import configuration.AppProperties;

public abstract class AbstractClient<T> {
	protected WebResource target;
	protected Client client;
	protected static final String BASE_URI = AppProperties.getInstance().getProperty("base_uri");
	protected Class<T> entityClass;
	protected String entityName;

	public AbstractClient(Class<T> entityClass,String entityName) {
		this.entityClass = entityClass;
		this.entityName = entityName;
		//it seems jersey is so bad at unmarshalling
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		this.client = Client.create(cfg);
		this.target = client.resource(BASE_URI).path(entityName);
	}

	public T find(long id) {
		WebResource res = target.path(java.text.MessageFormat.format("{0}", new Object[] { id }));
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(entityClass);
	}

	public abstract List<T> findAll();

	public void create(T entity) {
		WebResource res = target;
		res.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(entity);
	}

	public void update(T entity, long id) {
		WebResource res = target.path(java.text.MessageFormat.format("{0}", new Object[] { id }));
		res.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(entity);
	}

	public void remove(long id) {
		WebResource res = target.path(java.text.MessageFormat.format("{0}", new Object[] { id }));
		res.delete();
	}
}
