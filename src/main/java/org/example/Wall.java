package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                Optional<Block> foundBlock = findBlockByColorInCompositeBlock(color, (CompositeBlock) block);
            }
            if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
        }
        return Optional.empty();
    }

    private Optional<Block> findBlockByColorInCompositeBlock(String color, CompositeBlock compositeBlock) {
        for (Block block : compositeBlock.getBlocks()) {
            if (block instanceof CompositeBlock) {
                Optional<Block> foundBlock = findBlockByColorInCompositeBlock(color, (CompositeBlock) block);
                if (foundBlock.isPresent()) {
                    return foundBlock;
                }
            } else if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> blocksByMaterial = new ArrayList<>();
        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                blocksByMaterial.addAll(getBlocksOfSpecificMaterial(material, (CompositeBlock) block));
            } else if (block.getMaterial().equals(material)) {
                blocksByMaterial.add(block);
            }
        }
        return blocksByMaterial;
    }

    private List<Block> getBlocksOfSpecificMaterial(String material, CompositeBlock compositeBlock) {
        List<Block> blocksOfSpecificMaterial = new ArrayList<>();

        for (Block block : compositeBlock.getBlocks()) {
            if (block instanceof CompositeBlock) {
                blocksOfSpecificMaterial.addAll(getBlocksOfSpecificMaterial(material, (CompositeBlock) block));
            } else if (block.getMaterial().equals(material)) {
                blocksOfSpecificMaterial.add(block);
            }
        }
        return blocksOfSpecificMaterial;
    }


    @Override
    public int count() {
        int blocksCounter = 0;
        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                blocksCounter += countBlocksInComposite((CompositeBlock) block);
            } else {
                blocksCounter++;
            }
        }
        return blocksCounter;
    }

    private int countBlocksInComposite(CompositeBlock compositeBlock) {
        int blocksCounter = 0;
        for (Block block : compositeBlock.getBlocks()) {
            if (block instanceof CompositeBlock) {
                blocksCounter += countBlocksInComposite((CompositeBlock) block);
            } else {
                blocksCounter++;
            }
        }
        return blocksCounter;
    }
}

