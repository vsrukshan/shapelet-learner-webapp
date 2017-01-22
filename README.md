shapelet-learner-webapp
=================================
### How to run the programme
- `mvn clean install` to compile.
- Ececute `target\bin\webapp` to start the server.

### API URL patterns
* Get uploaded datasets (GET):- [http://localhost:8334/datasets](http://localhost:8334/datasets) returns a **json string**.
* Upload a dataset (POST):- Post the **multipart file** [http://localhost:8334//uploadFile](http://localhost:8334//uploadFile).
* Start learning (GET) :- [http://localhost:8334/learner/start?dataset=iris.arff&email=artisan@gmail.com](http://localhost:8334/learner/start?dataset=iris.arff&email=artisan@gmail.com).
* Get generated shapelets **json** file (GET) :- [http://localhost:8334/learner/results?dataset=iris](http://localhost:8334/learner/results?dataset=iris) returns a **json string**.

### Debugging
1. Intellij Idea can be used to remote debug this.
[![IDEA_debug _config.png](https://s27.postimg.org/ovr843xir/IDEA_debug_config.png)](https://postimg.org/image/j7kxd7t67/)
2. Then copy the **Command line argumemts for running remote JVM**.
3. Open `target\bin\webapp` and add the copied line before `tech.artisanhub.launch.Main \"$@"` and put a `\` after that. 
    ##### Example
        exec "$JAVACMD" $JAVA_OPTS \
        $EXTRA_JVM_ARGUMENTS \
        -classpath "$CLASSPATH" \
        -Dapp.name="webapp" \
        -Dapp.pid="$$" \
        -Dapp.repo="$REPO" \
        -Dbasedir="$BASEDIR" \
        -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 \
        tech.artisanhub.launch.Main \
        "$@"

4. Ececute `target\bin\webapp` to start the server.

