package org.maziarz.jadeit.webapp.requirement;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.maziarz.jadeit.dao.RequirementDao;
import org.maziarz.jadeit.model.Requirement;
import org.maziarz.jadeit.webapp.BasePage;

public class RequirementCreateUpdatePage extends BasePage {

	@SpringBean
	RequirementDao dao;
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	
	public RequirementCreateUpdatePage(PageParameters parameters) {
		super(parameters);
		
		id = parameters.get("id").toOptionalLong();
		
		add(new RequirementCreateUpdateForm("createUpdateForm", 
				
				new LoadableDetachableModel<Requirement>() {

					private static final long serialVersionUID = 1L;

					@Override
					protected Requirement load() {
						if (RequirementCreateUpdatePage.this.id != null) {
							return dao.load(RequirementCreateUpdatePage.this.id);
						} else {
							return new Requirement();
						}
					}}
			/*-
			 new IModel<Requirement>() {
			 

			private static final long serialVersionUID = 1L;
			
			@Override
			public void detach() {
				if (isAttached) {
					r = null;
					isAttached = false;
				}
			}
			
			private boolean isAttached = false;
			private Requirement r;

			@Override
			public Requirement getObject() {
				if (isAttached) {
					return r;
				} else {
					if (RequirementCreateUpdatePage.this.id != null) {
						r = dao.load(RequirementCreateUpdatePage.this.id);
					} else {
						r= new Requirement();
					}
					isAttached = true;
				}
				return r;
			}

			@Override
			public void setObject(Requirement object) {
				r = object;
				isAttached = true;
			}
		}
		*/
		));
	}


	
	public class RequirementCreateUpdateForm extends Form<Requirement> {

		private static final long serialVersionUID = 1L;

		Label label;
		TextField<String> nameTextField;
		TextArea<String> descriptionTextArea;

		public RequirementCreateUpdateForm(String id, final IModel<Requirement> model) {
			super(id, model);

			add(label = new Label("idLabel", Model.of(model.getObject().getId())));
			add(nameTextField = new TextField<String>("nameTextField", new IModel<String>(){

				private static final long serialVersionUID = 1L;

				@Override
				public void detach() {
				}

				@Override
				public String getObject() {
					return model.getObject().getName();
				}

				@Override
				public void setObject(String object) {
					model.getObject().setName(object);
					
				}}));
			add(descriptionTextArea = new TextArea<String>("descriptionTextArea", new PropertyModel<String>(model, "description")));
		}

		@Override
		protected void onConfigure() {
			label.setVisible(label.getDefaultModelObject() != null);
		}
		
		@Override
		protected void onSubmit() {
			Requirement modelObject = getModelObject();
			modelObject.setName(nameTextField.getModelObject());
			modelObject.setDescription(descriptionTextArea.getModelObject());
			dao.save(modelObject);
			
			setResponsePage(RequirementsPage.class);
		}

	}

}
