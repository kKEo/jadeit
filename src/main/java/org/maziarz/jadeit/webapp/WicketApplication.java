package org.maziarz.jadeit.webapp;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.maziarz.jadeit.webapp.requirement.RequirementCreateUpdatePage;
import org.maziarz.jadeit.webapp.requirement.RequirementsPage;

public class WicketApplication extends WebApplication {
	
	@Override
	public Class<RequirementsPage> getHomePage(){
		return RequirementsPage.class;
	}

	@Override
	public void init(){
		
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
		
		mountPage("rs", RequirementsPage.class);
		mountPage("r/#{id}", RequirementCreateUpdatePage.class);
		mountPage("t", TicketsPage.class);
	}
	
	@Override
	public Session newSession(Request request, Response response) {
		return super.newSession(request, response);
	}
}
