**TASK:**       
Implement the following methods in the Wall class:

findBlockByColor
findBlockByMaterial
count
Ensure to avoid code duplication and place all logic within the Wall class. Consider and implement the CompositeBlock
interface in your analysis.

**Analysis:**

Blocks have both color and material attributes. 
There are two possibilities:
- existence of individual blocks made of a single material and in a single color
- existence of composite blocks formed by combining several individual blocks

When dealing with a single block, the respective methods should return a specific block when given the appropriate
argument (color or material). In the case of a composite block, it's not possible to determine
the color or material of block because the individual blocks comprising the composite may have different colors or be made of
different materials. When dealing with a composite block, additional methods add to class Wall are used to break down the
composite blocks into individual blocks.

 