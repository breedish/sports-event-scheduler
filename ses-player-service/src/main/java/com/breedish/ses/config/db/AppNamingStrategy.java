package com.breedish.ses.config.db;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

public class AppNamingStrategy extends SpringPhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return super.toPhysicalTableName(new Identifier("ses_" + name.getText(), name.isQuoted()), context);
    }
}
