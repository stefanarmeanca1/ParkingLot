package org.parkinglot.parkinglot.ejb;

import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.parkingLot.entities.Car;
import org.example.parkingLot.entities.User;
import org.parkinglot.parkinglot.common.CarDTO;
import org.parkinglot.parkinglot.common.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean
{
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    EntityManager entitiyManager;

    List<UserDTO> copyUsersToDTO(List<User> users)
    {
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();

       for(User user : users)
       {
           UserDTO userDTO = new UserDTO(user.getId(),
                                      user.getUsername(),
                                      user.getEmail());

           userDTOs.add(userDTO);
       }

       return userDTOs;
    }

    public List<UserDTO> findAllUsers()
    {
        LOG.info("findAllUsers");

        try
        {
            TypedQuery<User> typedQuery = entitiyManager.createQuery("SELECT u FROM User u", User.class);
            List<User> users = typedQuery.getResultList();
            return copyUsersToDTO(users);
        }

        catch(Exception ex)
        {
            throw new EJBException(ex);
        }
    }
}
