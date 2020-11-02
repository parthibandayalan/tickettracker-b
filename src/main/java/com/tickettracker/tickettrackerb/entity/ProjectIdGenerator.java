package com.tickettracker.tickettrackerb.entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ProjectIdGenerator implements IdentifierGenerator {

	// @Autowired
	// ProjectService projectService = BeanUtil.getBean(ProjectService.class);
	// ProjectService projectService = new ProjectService();
	// ProjectJpaRepository projectRepository =
	// BeanUtil.getBean(ProjectJpaRepository.class);
	static Long generatedId = (long) 1;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		String prefix = "PJ";

		Connection connection = session.connection();

		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select count(*) from t_project");

			if (rs.next()) {
				int id = rs.getInt(1) + 101;
				String generatedId = prefix + new Integer(id).toString();
				System.out.println("Generated Id: " + generatedId);
				return generatedId;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}