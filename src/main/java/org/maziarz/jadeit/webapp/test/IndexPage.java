package org.maziarz.jadeit.webapp.test;

import java.util.ArrayList;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class IndexPage extends WebPage {

	private static final long serialVersionUID = 1L;

	public IndexPage() {

		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList.add("A");
		arrayList.add("B");
		arrayList.add("C");
		
		add(new ListView<String>("testpages", arrayList) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<String> item) {
				item.add(new Label("l", item.getModel()));
			}

		});

	}

}
