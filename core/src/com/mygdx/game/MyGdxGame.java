package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sun.java.accessibility.util.java.awt.TextComponentTranslator;

import java.awt.Point;
import java.util.PrimitiveIterator;

import static com.badlogic.gdx.Input.Keys.T;

public class MyGdxGame extends ApplicationAdapter {

	private Sun sun;
	private Earth earth;
	private Earth nPlanet;
	private Earth mPlanet;
	private PerspectiveCamera camera;
	private ModelBatch modelBatch;
	private ModelBuilder modelBuilder;
	private Stage stage;
	private ImageButton button1;
	private int col_width, row_height;
	private Skin mySkin;
	private Environment environment;
	@Override
	public void create () {
		sun=new Sun(1f, Color.YELLOW);

		earth=new Earth(0.3f,Color.BLUE,sun,5f,90);

		nPlanet= new Earth(0.1f, Color.GREEN,earth,1.5f,60);

		mPlanet= new Earth(0.2f, Color.ORANGE,sun,6f,30);

		camera= new PerspectiveCamera(75, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.position.set(5f, 5f, 5f);
		camera.rotate(Vector3.X,90);
		camera.lookAt(0f,0f,0f);
		camera.near=0.1f;
		camera.far=300f;

		col_width=Gdx.graphics.getWidth()/12;
		row_height=Gdx.graphics.getHeight()/12;
		stage= new Stage();
		mySkin = new Skin(Gdx.files.internal("glassy/skin/glassy-ui.json"));
		Gdx.input.setInputProcessor(stage);
		button1 = new ImageButton(mySkin);
		button1.setSize(col_width*4,(float)(row_height*2.5));

		button1.setPosition(col_width,Gdx.graphics.getHeight()-row_height*2.8f);
		button1.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

				return true;
			}
		});
		stage.addActor(button1);

		modelBatch= new ModelBatch();
		modelBuilder= new ModelBuilder();
		sun.setModel( modelBuilder.createSphere(sun.getRadius()*2,sun.getRadius()*2,
				sun.getRadius()*2,100,100,
				new Material(new ColorAttribute(ColorAttribute.createDiffuse(sun.getColor()))),
						VertexAttributes.Usage.Position|VertexAttributes.Usage.Normal));
		sun.setModelInstance(new ModelInstance(sun.getModel(),0,0,0));


		earth.setModel(modelBuilder.createSphere(earth.getRadius()*2,earth.getRadius()*2,
				earth.getRadius()*2,100,100,
				new Material(new ColorAttribute(ColorAttribute.createDiffuse(earth.getColor()))),
				VertexAttributes.Usage.Position|VertexAttributes.Usage.Normal));
		earth.setModelInstance(new ModelInstance(earth.getModel(),earth.getCoord().getX(),earth.getCoord().getY(),earth.getCoord().getZ()));


		nPlanet.setModel(modelBuilder.createSphere(nPlanet.getRadius()*2,nPlanet.getRadius()*2,
				nPlanet.getRadius()*2,100,100,
				new Material(new ColorAttribute(ColorAttribute.createDiffuse(nPlanet.getColor()))),
				VertexAttributes.Usage.Position|VertexAttributes.Usage.Normal));
		nPlanet.setModelInstance(new ModelInstance(nPlanet.getModel(),nPlanet.getCoord().getX(),nPlanet.getCoord().getY(),nPlanet.getCoord().getZ()));


		mPlanet.setModel(modelBuilder.createSphere(mPlanet.getRadius()*2,mPlanet.getRadius()*2,
				mPlanet.getRadius()*2,100,100,
				new Material(new ColorAttribute(ColorAttribute.createDiffuse(mPlanet.getColor()))),
				VertexAttributes.Usage.Position|VertexAttributes.Usage.Normal));
		mPlanet.setModelInstance(new ModelInstance(mPlanet.getModel(),mPlanet.getCoord().getX(),mPlanet.getCoord().getY(),mPlanet.getCoord().getZ()));




		environment= new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight,1,1,1,1));



	}



	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);

		stage.act();
		camera.update();
		modelBatch.begin(camera);
		stage.draw();
		modelBatch.render(sun.getModelInstance(),environment);
		modelBatch.render(earth.getModelInstance(),environment);
		modelBatch.render(nPlanet.getModelInstance(),environment);
		modelBatch.render(mPlanet.getModelInstance(),environment);


		update();
		modelBatch.end();
	}

	public void update()	{

		if(button1.isChecked()) {
			earth.setCoord(earth.getFather().getCoord(), earth.getCoord().getAngle() + 0.01f);
			nPlanet.setCoord(nPlanet.getFather().getCoord(), nPlanet.getCoord().getAngle() + 0.08f);
			mPlanet.setCoord(mPlanet.getFather().getCoord(), mPlanet.getCoord().getAngle() + 0.04f);

			earth.getModelInstance().transform.setToTranslation(earth.getCoord().getX(), earth.getCoord().getY(), earth.getCoord().getZ());
			nPlanet.getModelInstance().transform.setToTranslation(nPlanet.getCoord().getX(), nPlanet.getCoord().getY(), nPlanet.getCoord().getZ());
			mPlanet.getModelInstance().transform.setToTranslation(mPlanet.getCoord().getX(), mPlanet.getCoord().getY(), mPlanet.getCoord().getZ());
		}

	}

	@Override
	public void dispose () {
		modelBatch.dispose();
		earth.dispose();
		nPlanet.dispose();
		mPlanet.dispose();
		stage.dispose();
	}
}