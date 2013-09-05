package org.maziarz.jadeit.model;

import org.hibernate.tool.hbm2ddl.SchemaExportTask;

public class SchemaExportPreview {

	public static void main(String[] args) {

		SchemaExportTask task = new SchemaExportTask();
		
		task.execute();

	}

}
