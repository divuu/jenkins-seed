job('DSL-Tutorial-1-Test') {
    scm {
        git('https://github.com/opstree/spring3hibernate.git', 'master')
    }
    triggers {
        scm('H/1 * * * *')
    }
    steps {
        shell('ls -l')
        maven('clean validate test compile')
    }
}
