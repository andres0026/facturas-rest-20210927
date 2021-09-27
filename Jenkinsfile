pipeline {
    agent { 
        any
    }

    stages {

        stage ("Descarga el código de la aplicación") {
            steps {
                git "https://github.com/andres0026/facturas-rest-20210927.git"
            }
        }

        stage('Compilar y empaquetar el proyecto'){
            steps{
                script{
                    if(isUnix()){
                        sh "mvn clean package"
                    }else{
                        bat "mvn clean package"
                    }

                }          
            }
        }

        stage('Creación de image'){
            steps{
                script{
                    if(isUnix()){
                        sh "docker build -t areyes/app-java ."
                    }else{
                        bat "docker build -t areyes/app-java ."
                    }

                }          
            }
        }

        stage('Ejecución de contenedor'){
            steps{
                script{
                    if(isUnix()){
                        sh "docker run -d --name app-java -p 1800:8080 areyes/app-java"
                    }else{
                        bat "docker run -d --name app-java -p 1800:8080 areyes/app-java"
                    }

                }          
            }
        } 
        
        stage("Test del servicio"){
            steps {
                echo "Probando el servicio ..."
            }
        }

        stage("Cerrar recursos"){
           steps {
               script{
                    if(isUnix()){
                        sh "docker stop app-java"
                        sh "docker container rm app-java" 
                        sh "docker image rm areyes/app-java" 
                    }else{
                        bat "docker stop app-java"
                        bat "docker container rm app-java" 
                        bat "docker image rm areyes/app-java" 
                    }
               }
            }            
        }
    }
}
