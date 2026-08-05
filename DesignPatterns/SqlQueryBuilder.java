package DesignPatterns;

public class SqlQueryBuilder {
    StringBuilder query = new StringBuilder();
    int cond = 0;
    
    public SqlQueryBuilder select (String... columns){
        int size = columns.length;
        query.append("SELECT ");
        for(String col : columns){
            if(size == 1)
                query.append(col + " ");
            else
                query.append(col + ", ");

            size --;
        }

        return this;
    }

    public SqlQueryBuilder from (String table){
        query.append("FROM " + table + " ");

        return this;
    }

    public SqlQueryBuilder where(String condition){
        if(cond == 0)
            query.append("WHERE ");

        if(cond >= 1)
            query.append("AND ");
        
        query.append(condition + " ");
        this.cond ++;
        return this;
    }

    public String toString(){
        return query.toString();
    }



    public static void main(String[] args) {
        SqlQueryBuilder query = new SqlQueryBuilder()
                .select("nombre", "edad")
                .from("estudiantes")
                .where("edad > 18")
                .where("carrera = 'INGC'");

        System.out.println(query);
        // SELECT nombre, edad FROM estudiantes WHERE edad > 18 AND carrera = 'INGC'
    }
}
