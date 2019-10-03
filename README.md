# sibur
Java Api
1) Дан текстовый файл (.txt) содержащий список строк
Пример текстового файла (strings.txt): 
Monstrous
Produce
Razón
De la
El sueño

- Необходимо написать класс (Main), который прочитает этот файл и сохранит список построчно в другом файле в обратном порядке (strings _reverse.txt);


2) Дан xml-файл содержащий список сервлетов с маппингом на исполняемые классы.
(Пример:
<servlet>
      <servlet-name>WorkDelegationServlet</servlet-name>
      <servlet-class>com.croc.documentum.ksed.workdelegation.WorkDelegationServlet</servlet-class>
 </servlet>
 <servlet-mapping>
        <servlet-name>WorkDelegationServlet</servlet-name>
        <url-pattern>/WorkDelegationServlet</url-pattern>
 </servlet-mapping>)

- Необходимо написать класс(-ы) , который, прочитав/разпарсив файл (как текст или xml), составит список сервлетов с их маппингом построчно т.е. <servlet-name> -  <servlet-class> - <url-pattern>
(Пример WorkDelegationServlet - com.croc.documentum.ksed.workdelegation.WorkDelegationServlet - /WorkDelegationServlet)
и сохранит этот список в алфавитном порядке (по servlet-name) в отдельный файл (servlets_output.txt);

Java Api + Apache POI 
3) Дан файл базы данных Access  (DB.accdb или DB.mdb), содержащий таблицу templates (список шаблонов организаций).
- Необходимо написать класс(-ы), который извлечет по ключам  из файла настроек (connect.properties)  адрес  и имя таблицы, подключится к ней и извлечет данные по всем НЕ удаленным шаблонам (т.е. те у которых hiddenDelete = No) и используя функционал Apache POI сохранить выгрузку данных в формате .XLSX (export.xlsx) по указанному в файле настроек пути + имяфайла + timestamp (временную метку выполнения).
Примечание:	
По коннекту к Access (можно использовать любую версию java и драйвер)
Difference between Java version until 1.7 and Java 1.8 version
Until Java 1.7 version, we are using Jdbc-Odbc bridge to connect MS Access database using the JDBC driver class sun.jdbc.odbc.JdbcOdbcDriver
Whereas in Java 1.8 version, ucanaccess driver should be used to connect to MS Access database using driver class net.ucanaccess.jdbc.UcanaccessDriver
