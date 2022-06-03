job('spring3hibernate-maven-build') {
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
