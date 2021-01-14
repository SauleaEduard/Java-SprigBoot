package com.labjava.question.Repo;

import com.labjava.question.Model.Question;
import com.labjava.question.Model.User;
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
public class QuestionRepo {
    private JdbcTemplate jdbcTemplate;
    public QuestionRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;}

    public Question createQuestion(Question question){
        String sql = "insert into question values(?,?,?, ?)";
        PreparedStatementCreator preparedStatementCreator= connection ->{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,null);
            preparedStatement.setString(2, Long.toString(question.getU_id()));
            preparedStatement.setString(3, question.getTitlu());
            preparedStatement.setString(4, question.getDesc());
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);
        question.setId(generatedKeyHolder.getKey().longValue());
        return question;
    }
    public Optional<Question> getByTitlu(String titlu) {
        String sql = "select * from question q where q.titlu = ?";
        RowMapper<Question> rowMapper = (resultSet, rowNum) -> {
            Question question = new Question();
            question.setId(resultSet.getInt("id"));
            question.setU_id(resultSet.getInt("u_id"));
            question.setTitlu(resultSet.getString("titlu"));
            question.setTitlu(resultSet.getString("desc"));
            return question;
        };
        List<Question> result = jdbcTemplate.query(sql,rowMapper,titlu);
        if(null != result && !result.isEmpty()){
            return Optional.of(result.get(0));
        } else {
            return Optional.empty();
        }
    }

    public void postquestion(Question question){
        String sql = "update question q set q.titlu = ?, q.descriere = ? where q.id= ?";
        jdbcTemplate.update(sql,question.getTitlu(),question.getDesc(),question.getId());
    }
}
