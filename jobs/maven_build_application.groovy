// Jenkins Job DSL definition file for generating a Job for 
// https://github.com/anuradhaneo/springboot-api-demo

String basePath = 'springboot-api-demo'
String gitRepository = 'opstree/spring3hibernate'
String buildBranch = '*/master'
String projectName = 'Build Project'
String projectDisplayName = 'Springboot API Sample'
String projectDescription = 'This example shows basic folder/job creation'
String credentialIDGithub = 'github-anuradhaneo'
String artifactGroupID = 'org.spring.boot.sample'
String artifactID = 'SpringBootRestApiExample'
final String HTTP = 'http'
final String HTTPS = 'https'
// root folder creation
folder(basePath) {
    displayName(projectDisplayName)
    description(projectDescription)
}
// job definition
mavenJob(basePath + '/' + projectName) {
    description('Build the Java roject: ' + gitRepository)
    scm {
        git {
            branch(buildBranch)
            remote {
                github (gitRepository, HTTPS, 'github.com')
                credentials(credentialIDGithub)
            }
        }
    }
    triggers {
        scm('@daily')
    }
    wrappers {
        goals('clean install')
    }
}
