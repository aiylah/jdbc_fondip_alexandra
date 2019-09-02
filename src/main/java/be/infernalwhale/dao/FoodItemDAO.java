package be.infernalwhale.dao;

import be.infernalwhale.model.FoodItem;
import be.infernalwhale.model.Ticket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FoodItemDAO {
    public List<FoodItem> getItemsForTicket(int ticketID) throws SQLException {
        PreparedStatement statement = DBConnector
                .getConnection()
                .prepareStatement("SELECT * FROM fooditem WHERE ticket = ?");
        statement.setInt(1,ticketID);

        ResultSet rs = statement.executeQuery();

        List<FoodItem> result = null;
        while (rs.next()){
            result.add(new FoodItem(new Ticket())
                    .setId(rs.getInt("Id"))
                    .setName(rs.getString("Name"))
                    .setPrice(rs.getDouble("Price")));
            } return result;
        }

        public void createFoodItem(FoodItem foodItem) throws SQLException{
        PreparedStatement statement = DBConnector
                .getConnection()
                .prepareStatement("INSERT INTO fooditem (name, price, ticket) VALUES (?,?,?)");
        statement.setString(1,foodItem.getName());
        statement.setDouble(2,foodItem.getPrice());
        statement.setInt(3,foodItem.getTicketId());
        }
    }
