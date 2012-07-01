def xml = '''
<shops>
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


// Find first match
assert 1 == shops.shop.find {it.@location == 'Rye' }.size()

// Find all matches
assert 2 == shops.shop.findAll { it.@location == 'Rye' }.size()

// Total count of all apples
assert 4337 ==  shops.shop.stock.apples.collect{it.toInteger()}.sum()

// Another way to count the number of apples
assert 4337 == shops.'**'.findAll {it.name() == "apples"}.collect{it.toInteger()}.sum()

// Count the number of apples in Rye
assert 337 == shops.shop.findAll { it.@location == 'Rye' }.collect{it.stock.apples.toInteger()}.sum()

// Get unique locations
assert ['London', 'Rye'] == shops.shop.@location.collect{it.text()}.unique()

// Find all the names of shops that sell oranges
assert ['Cando'] == shops.shop.findAll{ it.'**'.findAll{it.name() == 'oranges'} }.collect{it.@name.text()}


