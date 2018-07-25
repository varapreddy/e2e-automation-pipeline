#!groovy
node {
    stage('Git checkout') { // for display purposes
        git 'https://github.com/varapreddy/e2e-automation-pipeline.git'
    }
    stage('Run Tests'){
        try{
            bat 'mvn clean verify'
        }catch (err) {

        } finally {
            publishHTML (target: [
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: "Regression test report"
            ])
        }
    }
    stage('Smoke'){
        try {
            bat 'mvn clean verify -Dtags="type:Smoke"'
        }catch (err) {

        } finally {
            publishHTML (target: [
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: "Smoke tests report"
            ])
        }
    }
    
    stage('API'){
        try{
            bat 'mvn clean verify -Dtags="type:API"'
        }catch (err) {

        } finally {
            publishHTML (target: [
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: "API tests report"
            ])
        }
    }
    stage('UI'){
        try{
            bat 'mvn clean verify -Dtags="type:UI"'
        }catch (err) {

        } finally {
            publishHTML (target: [
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: "UI tests report"
            ])
        }
    }

    
    stage('Results') {
        junit '**/target/failsafe-reports/*.xml'
    }
}