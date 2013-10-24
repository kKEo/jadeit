package org.maziarz.jadeit.webapp.requirement;

import java.util.Iterator;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.maziarz.jadeit.dao.RequirementDao;
import org.maziarz.jadeit.model.Requirement;
import org.maziarz.jadeit.webapp.BasePage;

public class RequirementsPage extends BasePage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	RequirementDao dao;

	public RequirementsPage(PageParameters parameters) {
		super(parameters);

		IDataProvider<Requirement> iDataProvider = new IDataProvider<Requirement>() {

			private static final long serialVersionUID = 1L;

			@Override
			public void detach() {
			}

			@Override
			public Iterator<? extends Requirement> iterator(long first, long count) {
				return dao.list((int) first, (int) count).listIterator();
			}

			@Override
			public long size() {
				return dao.count();
			}

			@Override
			public IModel<Requirement> model(final Requirement object) {

				return new LoadableDetachableModel<Requirement>() {

					private static final long serialVersionUID = 1L;

					@Override
					protected Requirement load() {
						return object;
					}
				};
			}
		};
		DataView<Requirement> rows;
		
		add(rows = new DataView<Requirement>("rows", iDataProvider) {

			private static final long serialVersionUID = 1L;

			public void populateItem(final Item<Requirement> item) {
				final Requirement user = item.getModelObject();
				item.add(new Label("id", user.getId()));
				item.add(new Label("name", user.getName()));
				PageParameters parameters2 = new PageParameters();
				parameters2.add("id", user.getId());
				item.add(new BookmarkablePageLink<RequirementCreateUpdatePage>("edit", RequirementCreateUpdatePage.class, parameters2));
			}

		});
		
		rows.setItemsPerPage(4);
		
		add(new PagingNavigator("paginator", rows));
		
	}



}
