
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;

import java.awt.Rectangle;
import javax.swing.JComponent;
import java.awt.Dimension;


public class DanielOutpostCanvas extends JComponent{

    int BLOCK_WIDTH = 20; // width of block in pixels
    int NUM_BLOCKS = 40; // width of canvas in blocks

    Color EMPTY_BLOCK_COLOR = new Color(255,255,255);
    Color FILL_BLOCK_COLOR = new Color(0,0,0);

    Color canvasBlockColors[][];

    
    public DanielOutpostCanvas () {
        
        System.out.println("Canvas Created");
        this.canvasBlockColors = new Color [this.NUM_BLOCKS][this.NUM_BLOCKS]; // Using Colors so that a block can have multiple colors
    
        this.clearBlocksColor();
    } // End of DanielOutpostCanvas

    @Override
    public void paintComponent(Graphics g){


        Graphics2D graphicsObj = (Graphics2D) g;

        

        for(int i = 0; i < this.NUM_BLOCKS; i++){

            for(int j = 0; j < this.NUM_BLOCKS; j++){

                graphicsObj.setColor(this.canvasBlockColors[i][j]);
                graphicsObj.fill( new Rectangle(i*this.BLOCK_WIDTH,j*this.BLOCK_WIDTH,this.BLOCK_WIDTH,this.BLOCK_WIDTH) );
            }
        }
            
    }
    public Dimension getPreferredSize() {
        return new Dimension(this.NUM_BLOCKS * this.BLOCK_WIDTH ,this.NUM_BLOCKS * this.BLOCK_WIDTH);
    };

    public void updateBlockColor(int blockPosX, int blockPosY, Color blockColor){
        this.canvasBlockColors[blockPosX][blockPosY] = blockColor;
    }

    public void clearBlocksColor(){
        // Set All Colors to EMPTY_BLOCK_COLOR
        for(int i = 0; i < this.NUM_BLOCKS; i++){
            for(int j = 0; j < this.NUM_BLOCKS; j++){
                this.canvasBlockColors[i][j] = this.EMPTY_BLOCK_COLOR;
            }
        }
    }

}
