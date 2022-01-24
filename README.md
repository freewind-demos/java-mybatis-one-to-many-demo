Java MyBatis One to Many Demo
==============================

可以在MyBatis中的`@Result`中通过`@Many`指定某个property的一对多关系。

有疑问的地方在于，一对多查询是分成多个SQL从而可能会有N+1性能问题吗？

下面的命令会执行一对多查询：
```
http GET http://localhost:8099/api/messages
```

经过测试，在db下的`demo.trace.db`log文件中，可以发现的确是执行了多条。

```
/**/prep6.execute();
/**/prep7.execute();
/**/prep8.execute();
/**/prep9.execute();
```

所以存在N+1问题

```
brew install httpie
./mvnw package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

```
http POST http://localhost:8099/api/messages text=aaa
http POST http://localhost:8099/api/messages text=bbb

http POST http://localhost:8099/api/messages text=aa##bb

http GET http://localhost:8099/api/messages

http GET http://localhost:8099/api/messages/0
```

Then

```
http://localhost:8099/h2
```

with

```
JDBC_URL: jdbc:h2:mem:demo
USER NAME: sa
PASSWORD: sa
```
