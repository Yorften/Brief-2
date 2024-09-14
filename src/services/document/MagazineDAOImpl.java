package src.services.document;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.business.Magazine;
import src.dao.interfaces.MagazineDAO;

public class MagazineDAOImpl implements MagazineDAO {
    private List<Magazine> magazines = new ArrayList<>();

    @Override
    public Optional<Magazine> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Magazine> getAll() {

        return magazines;
    }

    @Override
    public void save(Magazine magazine) {

    }

    @Override
    public void update(Magazine magazine, String[] params) {

    }

    @Override
    public void delete(Magazine magazine) {
        throw new UnsupportedOperationException("Delete operation is not supported.");
    }
}
