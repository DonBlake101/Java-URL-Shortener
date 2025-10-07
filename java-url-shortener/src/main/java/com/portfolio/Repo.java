package com.portfolio;
import java.sql.*; import java.util.Optional;
public class Repo {
  private final Connection conn; public Repo(Connection c){ this.conn=c; }
  public static Repo init() throws Exception { Connection c=DriverManager.getConnection("jdbc:h2:mem:urls;DB_CLOSE_DELAY=-1"); try(Statement s=c.createStatement()){ s.execute("CREATE TABLE urls(id IDENTITY PRIMARY KEY, code VARCHAR(12) UNIQUE, target VARCHAR(2048))"); } return new Repo(c); }
  public String create(String code,String target) throws Exception { try(PreparedStatement ps=conn.prepareStatement("INSERT INTO urls(code,target) VALUES(?,?)")){ ps.setString(1,code); ps.setString(2,target); ps.executeUpdate(); return code; } }
  public Optional<String> find(String code) throws Exception { try(PreparedStatement ps=conn.prepareStatement("SELECT target FROM urls WHERE code=?")){ ps.setString(1,code); ResultSet rs=ps.executeQuery(); if(rs.next()) return Optional.of(rs.getString(1)); return Optional.empty(); } }
}
