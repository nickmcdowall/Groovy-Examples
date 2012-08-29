
import static java.util.Calendar.YEAR
import java.awt.Desktop
import groovy.xml.MarkupBuilder

def desktop = Desktop.getDesktop()

def xmlFile = new File("XmlMadeByGroovy.xml")
def xmlFileWriter = new FileWriter(xmlFile)
def xmlBuilder = new MarkupBuilder(xmlFileWriter)
def today = new Date()

xmlBuilder.people{
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
    }
}

println xmlFile.getText()

/** If using Java 6 or later this should open browser - if JVM allows it. **/
desktop.browse(xmlFile.toURI())


/** 
 * Building some HTML 
**/

def htmlFile = new File("HtmlMadeByGroovy.html")
def htmlFileWriter = new FileWriter(htmlFile)
def htmlBuilder = new MarkupBuilder(htmlFileWriter)

htmlBuilder.html{
	header{
		h1"Welcome"
	}
	body{
		p"Hello World, doesn't Groovy rock!?"
		em{
			p"By the way today is ${ today.format("EEEE") }!"
		}
		table{
			tr(bgcolor:'silver'){
				th"Language"
				th"Comments"
			}
			tr{
				td{
					a(href:"http://groovy.codehaus.org/", "Groovy")
				}
				td"Awesome"
			}
		}
	}
}

println htmlFile.getText()
desktop.browse(htmlFile.toURI())