package edu.neu.cs5200.msn.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import edu.neu.cs5200.msn.orm.models.Site;

@Path("/site")
public class SiteDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
	EntityManager em = factory.createEntityManager();
	
	
	// createSite
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> createSite(Site site) {
		em.getTransaction().begin();
		em.persist(site);
		em.getTransaction().commit();
		return findAllSites();
	}
	
	// findSiteById
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSiteById(@PathParam("id") int id)
	{
		return em.find(Site.class, id);
	}
	
	// findAllSites
	@SuppressWarnings("unchecked")
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> findAllSites()
	{
		Query  query = em.createQuery("select site from Site site");
		return (List<Site>)query.getResultList();
		
	}
	
	// updateSite
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite(@PathParam("id") int siteId, Site site)
	{
		em.getTransaction().begin();
		em.merge(site);
		em.getTransaction().commit();
		return findAllSites();
	}
	
	// removeSite
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> removeSite(@PathParam("id") int id) {
		em.getTransaction().begin();
		Site site = em.find(Site.class, id);
		em.remove(site);
		em.getTransaction().commit();
		return findAllSites();
	}

	
	public static void main(String[] args) {
		 SiteDAO dao = new SiteDAO();
		 
//		 Site site = new Site(null, "New York","40.71","74.00");
//		 site = dao.createSite(site);
//		 System.out.println(site.getId());
		 
//		 Site NewYork = dao.findSiteById(3);
//		 System.out.println(NewYork.getName());
		 
		 //dao.removeSite(3);
		 
//		 List<Site> sites = dao.findAllSites();
//		 for(Site site :sites)
//		 {
//			 System.out.println(site.getName());
//		 }
		 
//		 NewYork.setLatitude("unknown");
//		 dao.updateSite(NewYork);
		 
//		 Site boston = dao.findSiteById(1);
//		 System.out.println(boston.getTowers().size());
//		 
//		 List<Tower> towers = boston.getTowers();
//		 for(Tower tower: towers)
//		 {
//			 System.out.println(tower.getName());
//		 }
		 
				 
		 
		 
	}

	

}
