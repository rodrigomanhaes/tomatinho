repositories.remote << 'http://repo1.maven.org/maven2'

JODA_TIME= 'joda-time:joda-time:jar:2.1'
JUNIT = 'junit:junit:jar:4.10'
HAMCREST = 'org.hamcrest:hamcrest-all:jar:1.1'
MOCKITO = 'org.mockito:mockito-all:jar:1.9.0'

define 'tomatinho' do
  project.version = '0.1.0'
  compile.with JODA_TIME
  test.with JUNIT, HAMCREST, MOCKITO
  package :jar
end