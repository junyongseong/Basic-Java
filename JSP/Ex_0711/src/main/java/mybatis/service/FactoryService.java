package mybatis.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class FactoryService {
    private static SqlSessionFactory factory;

    static {
        try {
            Reader r = Resources.getResourceAsReader(
                    "mybatis/config/conf.xml");
            factory = new SqlSessionFactoryBuilder().build(r);
            r.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static SqlSessionFactory getFactory(){
        return factory;
    }
}
