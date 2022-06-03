job('DSL-Tutorial-1-Test') {
    scm {
        git('https://github.com/opstree/spring3hibernate.git')
    }
    triggers {
        scm('H/1 * * * *')
    }
    steps {
        maven('-f pom.xml clean validate test compile')
    }
}
