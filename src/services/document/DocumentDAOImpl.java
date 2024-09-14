package src.services.document;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.business.Book;
import src.business.Document;
import src.dao.interfaces.DocumentDAO;
import src.db.DatabaseConnection;

public class DocumentDAOImpl implements DocumentDAO {
    private static final String SQL_LIST = "SELECT * FROM public.document WHERE is_deleted = false ORDER BY id ASC";
    private static final String SQL_DELETE = "UPDATE public.document SET is_deleted = ? WHERE id = ?;";

    @Override
    public List<Document> getAll() {
        List<Document> documentsList = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_LIST);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                LocalDate publicationDate = resultSet.getDate("publication_date").toLocalDate();
                int pageNumbers = resultSet.getInt("page_numbers");

                Book book = new Book(id, name, author, publicationDate, pageNumbers);
                documentsList.add(book);

                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving users: " + e.getMessage());
        }

        return documentsList;
    }

    public void delete(Document document) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);

            statement.setBoolean(1, true);

            statement.setLong(2, document.getId());

            statement.executeUpdate();
            connection.close();

            System.out.println("User deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ----------------- UNSEUPPORTED METHODS ----------------- */

    @Override
    public Optional<Document> get(long id) {
        throw new UnsupportedOperationException("Get operation is not supported in DocumentDAOImpl.");
    }

    public void save(Document document) {
        throw new UnsupportedOperationException("Save operation is not supported in DocumentDAOImpl.");
    }

    public void update(Document document, String[] params) {
        throw new UnsupportedOperationException("Update operation is not supported in DocumentDAOImpl.");
    }
}
