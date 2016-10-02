package za.co.applications.princegains.shopping.shopping.dao;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import za.co.applications.princegains.shopping.shopping.model.SystemUser;

public class UserDaoImpl extends AbstractDao<Integer, SystemUser> implements UserDao {

    private static final UserDao INSTANCE = new UserDaoImpl();

    public static UserDao getInstance() {
        return INSTANCE;
    }

    public SystemUser findById(int id) {
        return getByKey(id);
    }

    public SystemUser findBySSO(String sso) {
        Transaction transaction = getSession().beginTransaction();

        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        SystemUser systemUser = (SystemUser) crit.uniqueResult();
        transaction.commit();
        return systemUser;
    }

    @Override
    public SystemUser createUser(SystemUser systemUser) {
        Transaction transaction = getSession().beginTransaction();
        save(systemUser);
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssoId", systemUser.getSsoId()));
        SystemUser user = (SystemUser) criteria.uniqueResult();
        transaction.commit();
        return user;
    }


}
