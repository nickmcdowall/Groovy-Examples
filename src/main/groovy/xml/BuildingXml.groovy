
import groovy.xml.MarkupBuilder
import static java.util.Calendar.YEAR

def today = new Date()

def writer = new StringWriter()
def xml = new MarkupBuilder(writer)

xml.people{
    header(date: today)
    person{
        name"Nick"
        age"29"
        address{
            town"Ashford"
            county"Kent"
            country"England"
        }
    }
    person{
        name("Bob", middle:'Jim', last:'Brazer')
        def yearOfBirth = 1967
        def age = today[YEAR] - today.updated(year:yearOfBirth)[YEAR]
        xml.age(year:yearOfBirth, age)
    }
}

print writer

/** The output will look something like this:
<people>
  <header date='Sun Jul 15 14:52:29 BST 2012' />
  <person>
    <name>Nick</name>
    <age>29</age>
    <address>
      <town>Ashford</town>
      <county>Kent</county>
      <country>England</country>
    </address>
  </person>
  <person>
    <name middle='Jim' last='Brazer'>Bob</name>
    <age year='1967'>45</age>
  </person>
</people>
**/



