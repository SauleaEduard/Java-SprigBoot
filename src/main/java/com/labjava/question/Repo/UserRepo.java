package com.labjava.question.Repo;

import com.labjava.question.Model.User;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepo {
    private JdbcTemplate jdbcTemplate;

    public UserRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User createUser(User user) {
        String sql = "insert into users values(?,?,?)";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, user.getNick());
            preparedStatement.setString(3, user.getEmail());
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);
        user.setId(generatedKeyHolder.getKey().longValue());
        return user;
    }

    public Optional<User> getByEmail(String email) {
        String sql = "select * from users u where u.email = ?";
        RowMapper<User> rowMapper = (resultSet, rowNum) -> {
            User user = new User();
            user.setNick(resultSet.getString("nick"));
            user.setEmail(resultSet.getString("email"));
            user.setId(resultSet.getLong("id"));
            return user;
        };
        List<User> result = jdbcTemplate.query(sql, rowMapper, email);
        if (null != result && !result.isEmpty()) {
            return Optional.of(result.get(0));
        } else {
            return Optional.empty();
        }
    }

    public Optional<User> getUser(long id) {
        String sql = "select * from users u where u.id = ?";
        RowMapper<User> rowMapper = (resultSet, rowNum) -> {
            User user = new User();
            user.setNick(resultSet.getString("nick"));
            user.setEmail(resultSet.getString("email"));
            user.setId(resultSet.getLong("id"));
            return user;
        };
        List<User> result = jdbcTemplate.query(sql, rowMapper, id);
        if (null != result && !result.isEmpty()) {
            return Optional.of(result.get(0));
        } else {
            return Optional.empty();
        }
    }
}