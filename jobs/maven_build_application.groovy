jobs('Spring-application-maven-seed-build') {

definition {
    cps {
        script('''
            tools {
                maven 'maven3.8.5'
            }
            stages {
                stage('Build') {
                steps {
                    echo 'Build Application started'
                    echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/opstree/spring3hibernate.git']]])
                    sh "mvn -f pom.xml clean validate test compile" 
                }
            }
            stage('Test') {
                steps {
                    echo 'Test Application'
                }
            }
            stage('Deploy') {
                steps {
                    echo 'Deploy Application'
                }
            }     
        }    
       '''.stripIndent())
       sandbox()
        }
    }
}
