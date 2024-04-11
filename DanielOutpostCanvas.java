/**
 * Daniel Beltran
 * 827004197
 * CSCE 708 - 600
 * 4/11/2024
 */

// Graphics Imports
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.awt.Dimension;

/**
 * This class is just a custom JComponent.
 * This canvas is just a matrix of blocks (NUM_BLOCK x NUM_BLOCK), 
 * The colors of each block is stored,
 * A block is of size BLOCK_WIDTH x BLOCK_WIDTH
 * 
 * The canvas is drawn when paintComponent is called
 */
public class DanielOutpostCanvas extends JComponent{

    // Block Size 
    int BLOCK_WIDTH = 20; // width of block in pixels

    // Number rows and columns
    int NUM_BLOCKS = 40; // width of canvas in blocks

    // Color Values used in Matrix
    Color EMPTY_BLOCK_COLOR = new Color(255,255,255);
    Color FILL_BLOCK_COLOR = new Color(0,0,0);

    // Stores the individual Block Colors 
    Color canvasBlockColors[][];

    
    // Constructor 
    public DanielOutpostCanvas () {
        
        // Initialize matrix
        this.canvasBlockColors = new Color [this.NUM_BLOCKS][this.NUM_BLOCKS]; // Using Colors so that a block can have multiple colors
        this.clearBlocksColor();

    } // End of DanielOutpostCanvas

    /**
     * Creates the blocks and set size according to what is stored in canvasBlockColors
     */
    @Override
    public void paintComponent(Graphics g){

        Graphics2D graphicsObj = (Graphics2D) g;

        // Loop though all the blocks
        for(int i = 0; i < this.NUM_BLOCKS; i++){
            for(int j = 0; j < this.NUM_BLOCKS; j++){

                graphicsObj.setColor(this.canvasBlockColors[i][j]);

                // Create the Rectangle and add to graphic (Draws the Canvas)
                graphicsObj.fill( new Rectangle(i*this.BLOCK_WIDTH,j*this.BLOCK_WIDTH,this.BLOCK_WIDTH,this.BLOCK_WIDTH) );
            }
        }
            
    } // End of paintComponent

    /**
     * This is required so that this JComponent is visible
     */
    public Dimension getPreferredSize() {
        return new Dimension(this.NUM_BLOCKS * this.BLOCK_WIDTH ,this.NUM_BLOCKS * this.BLOCK_WIDTH);
    };

    /**
     * Updates the canvasBlockColors array with the desired color
     * @param blockPosX Block X Position
     * @param blockPosY Block Y Position
     * @param blockColor New Block Color
     */
    public void updateBlockColor(int blockPosX, int blockPosY, Color blockColor){
        this.canvasBlockColors[blockPosX][blockPosY] = blockColor;
    }

    /*
     * Sets all block colors to the empty color
     */
    public void clearBlocksColor(){
        // Set All Colors to EMPTY_BLOCK_COLOR
        for(int i = 0; i < this.NUM_BLOCKS; i++){
            for(int j = 0; j < this.NUM_BLOCKS; j++){
                this.canvasBlockColors[i][j] = this.EMPTY_BLOCK_COLOR;
            }
        }
    } 

} // End of DanielOutpostCanvas
