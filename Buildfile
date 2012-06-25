repositories.remote << 'http://repo1.maven.org/maven2'

JUNIT = 'junit:junit:jar:4.10'

define 'tomatinho' do
  project.version = '0.1.0'
  test.with JUNIT
  package :jar
end