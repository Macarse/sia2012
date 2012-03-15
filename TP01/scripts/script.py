#!/usr/bin/python
import re

def main():
  positions = []
  items = []
  dict = {'D':'TileKind.Dot', 'B':'TileKind.Bamboo', 'C':'TileKind.Character', 'W':'TileKind.Wind', 'R':'TileKind.Dragon', 'S':'TileKind.Season', 'F':'TileKind.Flower'}
  f = open('salidita.txt')
  for line in f:
  	match = re.match( r'pos\s\[(\d+),(\d+),(\d+)\]item:\s(.+)(\d+)', line, re.M|re.I)
  	if match:
  		sentence = "positions.add(new Position(%s, %s, %s));\n" % (match.group(1), match.group(2), match.group(3))
  		item = "board.setItem(new Position(%s, %s, %s), new Tile(%s, %s));\n" % (match.group(1), match.group(2), match.group(3),  dict[match.group(4)], match.group(5)) 
  		positions.append(sentence)
  		items.append(item)

  for sentence in positions:
  	print sentence

  print '\n'

  for item in items:
  	print item

if __name__ == '__main__':
  main()