    def xml = '''
    <shops>
        <header id='123'>
            <date>2012-07-15</date>
        </header>
        <shop name='Algos' location='London'>
            <stock>
                <apples>4000</apples>
                <pears>3200</pears>
            </stock>
        </shop>
        <shop name='Brada' location='Rye'>
            <stock>
                <apples>137</apples>
                <pineapple>3200</pineapple>
            </stock>
        </shop>
        <shop name='Cando' location='Rye'>
            <stock>
                <apples>200</apples>
                <oranges>3200</oranges>
            </stock>
        </shop>
    </shops>
'''

def shops = new XmlSlurper().parseText(xml)

// Extracting values is simple
assert "2012-07-15" == shops.header.date.text()

// Accessing an attribute value using @ symbol
assert '123' == shops.header.@id.text()


/** Throwing in closures and iterator methods such as find **/

// Simple closure that checks for a location attribute value of 'Rye'
def basedInRye = {node -> node.@location == 'Rye' }
def findShopsInRye = {node -> node.breadthFirst().grep(basedInRye)}
def apples = {node -> node.name() == "apples"}
def findApples = { node -> node.breadthFirst().grep(apples) }
def oranges = {node -> node.name() == 'oranges'}
def findOranges = {node -> node.breadthFirst().findAll(oranges)}
def integerValue = {it.toInteger()}
def textValue = {it.text()}


// Find will only return first match
assert 1 == shops.shop.find(basedInRye).size()

// Find all will return all matches
assert 2 == shops.shop.findAll(basedInRye).size()

// Total count of all apples
assert 4337 ==  shops.shop.stock.apples*.toInteger().sum()

// Another way to count the number of apples
assert 4337 == findApples(shops).sum(integerValue)

// Count the number of apples in Rye using findAll
assert 337 == shops.shop.findAll(basedInRye).collect{it.stock.apples}.sum(integerValue)

// Count the number of apples in Rye using grep
assert 337 == shops.shop.grep(basedInRye).stock.apples.sum(integerValue)
assert 337 == findShopsInRye(shops).stock.apples.sum(integerValue)

// Get unique locations
assert ['London', 'Rye'] == shops.shop.@location.collect(textValue).unique()

// Same as above with 'spread-dot' operator
assert ['London', 'Rye'] == shops.shop.@location*.text().unique()

// Find all the names of shops that sell oranges
assert ['Cando'] == findOranges(shops).collect {it.parent().parent().@name.text()}

println "All asserts successful :-)"
