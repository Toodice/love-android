package net.schattenkind.androidLove.luan.module;

import javax.microedition.khronos.opengles.GL10;

import net.schattenkind.androidLove.LoveVM;
import net.schattenkind.androidLove.luan.obj.LuanObjFont;
import net.schattenkind.androidLove.luan.obj.LuanObjImage;
import net.schattenkind.androidLove.luan.obj.LuanObjParticleSystem;
import net.schattenkind.androidLove.luan.obj.LuanObjQuad;
import net.schattenkind.androidLove.utils.Rectangle;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;


public class LuanGraphics extends LuanRenderer {
	protected static final String TAG = "LoveGraphics";
	
	public LuanGraphics (LoveVM vm) { super(vm); }
	public static final String sMetaName_LuanImage = "__MetaLuanImage";
	public static final String sMetaName_LuanQuad = "__MetaLuanQuad";
	public static final String sMetaName_LuanFont = "__MetaLuanFont";
	public static final String sMetaName_LuanParticleSystem = "__MetaLuanParticleSystem";
	
	public void Log (String s) { LoveVM.LoveLog(TAG, s); }
	
	public float[] FloatArray (Varargs args,int start) {
		float[] res = new float[args.narg()-(start-1)]; // narg=1 start=1 -> numfloat=1-(1-1)=1
		for (int i=start;i<args.narg();++i) res[i-1] = (float)args.checkdouble(2);
		return res;
	}
	
	public LuaTable InitLib () {
		InitRenderer();
		try {
			mDefaultFont = new LuanObjFont(this);
			mFont = mDefaultFont;
		} catch (Exception e) {
			Log("warning, failed to load default font in LuanGraphics:InitLib");
			//~ vm.handleError(e);
		}
		LuaTable t = LuaValue.tableOf();
		LuaValue _G = vm.get_G();
		
		_G.set(sMetaName_LuanImage,LuanObjImage.CreateMetaTable(this));
		_G.set(sMetaName_LuanQuad,LuanObjQuad.CreateMetaTable(this));
		_G.set(sMetaName_LuanFont,LuanObjFont.CreateMetaTable(this));
		_G.set(sMetaName_LuanParticleSystem,LuanObjParticleSystem.CreateMetaTable(this));

		// ***** ***** ***** ***** ***** rest
		
		t.set("checkMode",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"checkMode"			); return LuaValue.NONE; } }); // TODO: not yet implemented	
		t.set("getCaption",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"getCaption"			); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("isCreated",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"isCreated"			); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("newFramebuffer",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"newFramebuffer"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("newScreenshot",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"newScreenshot"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("newSpriteBatch",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"newSpriteBatch"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("pop",				new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"pop"					); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("push",				new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"push"				); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("present",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"present"				); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("setCaption",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"setCaption"			); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("setIcon",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"setIcon"				); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("setRenderTarget",	new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"setRenderTarget"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("toggleFullscreen",	new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"toggleFullscreen"	); return LuaValue.NONE; } }); // TODO: not yet implemented
		
		
		
		// ***** ***** ***** ***** ***** rendering options
		
		t.set("getBackgroundColor",	new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"getBackgroundColor"	); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("getBlendMode",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"getBlendMode"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("getColor",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"getColor"			); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("getColorMode",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"getColorMode"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		
		t.set("setLine",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"setLine"				); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("setLineStipple",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"setLineStipple"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("setLineStyle",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"setLineStyle"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("setLineWidth",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"setLineWidth"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("setPoint",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"setPoint"			); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("setPointSize",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"setPointSize"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("setPointStyle",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"setPointStyle"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		
		// love.graphics.setScissor( )
		// love.graphics.setScissor( x, y, width, height )
		t.set("setScissor",			new VarArgFunction() { 
			@Override 
			public Varargs invoke(Varargs args) { 
				if (args.narg() == 0)
				{
					setScissor();
				}
				else if (args.narg() == 4)
				{
					setScissor(
							args.checkint(1), 
							args.checkint(2), 
							args.checkint(3), 
							args.checkint(4));
				}
				
				return LuaValue.NONE; 
			} 
		});
		
		
		t.set("getLineStipple",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"getLineStipple"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("getLineStyle",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"getLineStyle"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("getLineWidth",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"getLineWidth"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("getMaxPointSize",	new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"getMaxPointSize"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("getModes",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"getModes"			); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("getPointSize",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"getPointSize"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		t.set("getPointStyle",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"getPointStyle"		); return LuaValue.NONE; } }); // TODO: not yet implemented
		
		// x, y, width, height = love.graphics.getScissor( )
		t.set("getScissor",			new VarArgFunction() { 
			@Override 
			public Varargs invoke(Varargs args) { 
				if (isScissorEnabled())
				{
					Rectangle scissorBox = getScissorBox();
					return LuaValue.tableOf(new LuaValue[]{
						LuaValue.valueOf(scissorBox.left),
						LuaValue.valueOf(scissorBox.top),
						LuaValue.valueOf(scissorBox.width),
						LuaValue.valueOf(scissorBox.height)
					});
				}
				else
				{
					return LuaValue.NONE;	
				}
			} 
		});
		
		
		t.set("setBlendMode",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { setBlendMode(Str2BlendMode(args.checkjstring(1))); return LuaValue.NONE; } });
		t.set("setColorMode",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { setColorMode(Str2ColorMode(args.checkjstring(1))); return LuaValue.NONE; } });
		
		/// love.graphics.setBackgroundColor( red, green, blue )  // 0-255
		t.set("setBackgroundColor", new VarArgFunction() {
			@Override
			public Varargs invoke(Varargs args) {
				LuanColor rgba = new LuanColor(args);
				setBackgroundColor(rgba);
				return LuaValue.NONE;
			}
		});
		
		/// love.graphics.setColor( red, green, blue, alpha )  // 0-255
		t.set("setColor", new VarArgFunction() {
			@Override
			public Varargs invoke(Varargs args) {
				LuanColor rgba = new LuanColor(args);
				setForegroundColor(rgba);
				return LuaValue.NONE;
			}
		});
		
		// ***** ***** ***** ***** ***** basic geometry rendering
		
		/// love.graphics.quad( mode, x1, y1, x2, y2, x3, y3, x4, y4 )
		t.set("quad",				new VarArgFunction() { @Override public Varargs invoke(Varargs args) {
			DrawMode mode = Str2DrawMode(args.checkjstring(1));
			float x1 = (float)args.checkdouble(2);
			float y1 = (float)args.checkdouble(3);
			float x2 = (float)args.checkdouble(4);
			float y2 = (float)args.checkdouble(5);
			float x3 = (float)args.checkdouble(6);
			float y3 = (float)args.checkdouble(7);
			float x4 = (float)args.checkdouble(8);
			float y4 = (float)args.checkdouble(9);
			renderQuad(mode, x1, y1, x2, y2, x3, y3, x4, y4);
			return LuaValue.NONE; 
		} });
		
		/// love.graphics.triangle( mode, x1, y1, x2, y2, x3, y3 )
		t.set("triangle",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) {
			DrawMode mode = Str2DrawMode(args.checkjstring(1));
			float x1 = (float)args.checkdouble(2);
			float y1 = (float)args.checkdouble(3);
			float x2 = (float)args.checkdouble(4);
			float y2 = (float)args.checkdouble(5);
			float x3 = (float)args.checkdouble(6);
			float y3 = (float)args.checkdouble(7);
			renderTriangle(mode, x1, y1, x2, y2, x3, y3);
			return LuaValue.NONE;
		} });
		
		/// love.graphics.circle( mode, x, y, radius, segments = 10 )
		t.set("circle",				new VarArgFunction() { @Override public Varargs invoke(Varargs args) {
			DrawMode mode = Str2DrawMode(args.checkjstring(1));
			float x = (float)args.checkdouble(2);
			float y = (float)args.checkdouble(3);
			float radius = (float)args.checkdouble(4);
			int segments = IsArgSet(args,5) ? args.checkint(5) : 10;
			renderCircle(mode, x, y, radius, segments);
			return LuaValue.NONE;
		} });
		
		/// love.graphics.point( x, y )
		t.set("point",				new VarArgFunction() { @Override public Varargs invoke(Varargs args) {
			float x = (float)args.checkdouble(1);
			float y = (float)args.checkdouble(2);
			renderPoint(x, y);
			return LuaValue.NONE;
		} });
		
		/// love.graphics.rectangle( mode, x, y, width, height )
		t.set("rectangle",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) {
			DrawMode mode = Str2DrawMode(args.checkjstring(1));
			float x = (float)args.checkdouble(2);
			float y = (float)args.checkdouble(3);
			float w = (float)args.checkdouble(4);
			float h = (float)args.checkdouble(5);
			renderRectangle(mode, x, y, w, h);
			return LuaValue.NONE;
		} });
		
		/// love.graphics.line( x1, y1, x2, y2, ... )
		t.set("line",				new VarArgFunction() { @Override public Varargs invoke(Varargs args) {
			if (IsArgSet(args,5)) {
				renderPolyLine(FloatArray(args, 1));
			} else {
				float x1 = (float)args.checkdouble(1);
				float y1 = (float)args.checkdouble(2);
				float x2 = (float)args.checkdouble(3);
				float y2 = (float)args.checkdouble(4);
				renderLine(x1, y1, x2, y2);
			}
			return LuaValue.NONE;
		} });
		
		/// love.graphics.polygon( mode, ... )
		/// Note: when in fill mode, the polygon must be convex and simple or rendering artifacts may occur. 
		t.set("polygon",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) {
			DrawMode mode = Str2DrawMode(args.checkjstring(1));
			renderPolygon(mode, FloatArray(args, 2));
			return LuaValue.NONE;
		} });
		
		
		/// love.graphics.clear ( )
		/// Clears the screen to background color. 
		t.set("clear",				new VarArgFunction() { @Override public Varargs invoke(Varargs args) { getGL().glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT); return LuaValue.NONE; } });
		
		
		// ***** ***** ***** ***** ***** font + text
		
		t.set("getFont",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) { vm.NotImplemented("love.graphics."+"getFont"				); return LuaValue.NONE; } }); // TODO: not yet implemented
		
		/// love.graphics.print( text, x, y, r, sx, sy )
		/// Draws text on screen.
		t.set("print", new VarArgFunction() {
			@Override
			public Varargs invoke(Varargs args) {
				String s = args.checkjstring(1);
				float x = (float)args.checkdouble(2);
				float y = (float)args.checkdouble(3);
				float r = (IsArgSet(args,4)) ? ((float)args.checkdouble(4)) : 0f;
				float sx = (IsArgSet(args,5)) ? ((float)args.checkdouble(5)) : 1f;
				float sy = (IsArgSet(args,6)) ? ((float)args.checkdouble(6)) : sx;
				//~ Log("print:"+s);
				if (mFont != null) mFont.print(s, x, y, r, sx, sy);
				return LuaValue.NONE;
			}
		});
		
		/// love.graphics.printf( text, x, y, limit, align )
		/// NOTE: not related to c printf, rather wordwrap etc
		/// Draws formatted text, with word wrap and alignment. 
		t.set("printf", new VarArgFunction() {
			@Override
			public Varargs invoke(Varargs args) {
				String s = args.checkjstring(1);
				float x = (float)args.checkdouble(2);
				float y = (float)args.checkdouble(3);
				float limit = (float)args.checkdouble(4);
				String align = (IsArgSet(args,5)) ? args.checkjstring(5) : "left";
				//~ Log("printf:"+align+":"+s);
				if (mFont != null) mFont.printf(s,x,y,limit,LuanObjFont.Text2Align(align));
				return LuaValue.NONE;
			}
		});
		// todo : newImageFont, setfont,  print...
		
		/// font = love.graphics.newFont( filename, size ) 
		/// font = love.graphics.newFont( size )   (default font (Vera Sans))
		t.set("newFont", new VarArgFunction() {
			@Override
			public Varargs invoke(Varargs args) {
				if (args.isstring(1)) {
					String filename = args.checkjstring(1);
					int iSize = IsArgSet(args,2) ? args.checkint(2) : 12;
					try {
						return LuaValue.userdataOf(new LuanObjFont(LuanGraphics.this,filename,iSize),vm.get_G().get(sMetaName_LuanFont));
					} catch (Exception e) {
						vm.handleError(e);
					}
					return LuaValue.NONE;
				} else {
					int iSize = (IsArgSet(args,1)) ? args.checkint(1) : 12;
					try {
						return LuaValue.userdataOf(new LuanObjFont(LuanGraphics.this,iSize),vm.get_G().get(sMetaName_LuanFont));
					} catch (Exception e) {
						vm.handleError(e);
					}
					return LuaValue.NONE;
				}
			}
		});
		
		/// font = love.graphics.newImageFont( image, glyphs )
		t.set("newImageFont", new VarArgFunction() {
			@Override
			public Varargs invoke(Varargs args) {
				if (args.isstring(1)) {
					String filename = args.checkjstring(1);
					String glyphs = args.checkjstring(2);
					try {
						return LuaValue.userdataOf(new LuanObjFont(LuanGraphics.this,filename,glyphs),vm.get_G().get(sMetaName_LuanFont));
					} catch (Exception e) {
						vm.handleError(e);
					}
					return LuaValue.NONE;
				} else {
					LuanObjImage img = (LuanObjImage)args.checkuserdata(1,LuanObjImage.class);
					String glyphs = args.checkjstring(2);
					return LuaValue.userdataOf(new LuanObjFont(LuanGraphics.this,img,glyphs),vm.get_G().get(sMetaName_LuanFont));
				}
			}
		});
		
		
		/// love.graphics.setFont( font )
		t.set("setFont", new VarArgFunction() {
			@Override public Varargs invoke(Varargs args) {
				mFont = IsArgSet(args,1) ? (LuanObjFont)args.checkuserdata(1,LuanObjFont.class) : mDefaultFont;
				return LuaValue.NONE;
			}
		});
		
		// ***** ***** ***** ***** ***** rest
		

		/// img = love.graphics.newImage(sFileName)
		t.set("newImage", new VarArgFunction() {
			@Override
			public Varargs invoke(Varargs args) {
				String s = args.checkjstring(1);
				try {
					return LuaValue.userdataOf(new LuanObjImage(LuanGraphics.this,s),vm.get_G().get(sMetaName_LuanImage));
				} catch (Exception e) {
					vm.handleError(e);
				}
				return LuaValue.NONE;
			}
		});
		
		/// quad = love.graphics.newQuad( x, y, width, height, sw, sh )
		t.set("newQuad", new VarArgFunction() {
			@Override
			public Varargs invoke(Varargs args) {
				float x  = (float)args.checkdouble(1);
				float y  = (float)args.checkdouble(2);
				float w  = (float)args.checkdouble(3);
				float h  = (float)args.checkdouble(4);
				float sw = (float)args.checkdouble(5);
				float sh = (float)args.checkdouble(6);
				try {
					return LuaValue.userdataOf(new LuanObjQuad(LuanGraphics.this,x,y,w,h,sw,sh),vm.get_G().get(sMetaName_LuanQuad));
				} catch (Exception e) {
					vm.handleError(e);
				}
				return LuaValue.NONE;
			}
		});
		
		
		/// system = love.graphics.newParticleSystem( image, buffer )
		t.set("newParticleSystem",	new VarArgFunction() { 
			@Override
			public Varargs invoke(Varargs args) {
				LuanObjImage img = (LuanObjImage)args.checkuserdata(1,LuanObjImage.class);
				int iBufferSize = args.checkint(2);
				try {
					return LuaValue.userdataOf(new LuanObjParticleSystem(LuanGraphics.this,img,iBufferSize),vm.get_G().get(sMetaName_LuanParticleSystem));
				} catch (Exception e) {
					vm.handleError(e);
				}
				return LuaValue.NONE;
			}
		});

		/// love.graphics.draw(drawable, x, y, r=0, sx=1, sy=1, ox=0, oy=0)
		t.set("draw", new VarArgFunction() {
			@Override
			public Varargs invoke(Varargs args) {
				LuanObjDrawable drawable = (LuanObjDrawable)args.checkuserdata(1,LuanObjDrawable.class);
				float x = (float)args.checkdouble(2);
				float y = (float)args.checkdouble(3);
				float r  = (IsArgSet(args,4)) ? ((float)args.checkdouble(4)) : 0.0f;
				float sx = (IsArgSet(args,5)) ? ((float)args.checkdouble(5)) : 1.0f;
				float sy = (IsArgSet(args,6)) ? ((float)args.checkdouble(6)) : 1.0f;
				float ox = (IsArgSet(args,7)) ? ((float)args.checkdouble(7)) : 0.0f;
				float oy = (IsArgSet(args,8)) ? ((float)args.checkdouble(8)) : 0.0f;
				if (drawable.IsImage()) {
					LuanObjImage img = (LuanObjImage)drawable;
					DrawSprite(img.GetTextureID(),img.mWidth,img.mHeight,x,y,r,sx,sy,ox,oy);
				} else {
					drawable.RenderSelf(x,y,r,sx,sy,ox,oy);
				}
				return LuaValue.NONE;
			}
		});
		
		
		/// love.graphics.drawq( image, quad, x, y, r, sx, sy, ox, oy )
		t.set("drawq", new VarArgFunction() { 
			@Override public Varargs invoke(Varargs args) {
				LuanObjImage img = (LuanObjImage)args.checkuserdata(1,LuanObjImage.class);
				LuanObjQuad quad = (LuanObjQuad)args.checkuserdata(2,LuanObjQuad.class);
				float x = (float)args.checkdouble(3);
				float y = (float)args.checkdouble(4);
				float r  = (IsArgSet(args,5)) ? ((float)args.checkdouble(5)) : 0.0f;
				float sx = (IsArgSet(args,6)) ? ((float)args.checkdouble(6)) : 1.0f;
				float sy = (IsArgSet(args,7)) ? ((float)args.checkdouble(7)) : 1.0f;
				float ox = (IsArgSet(args,8)) ? ((float)args.checkdouble(8)) : 0.0f;
				float oy = (IsArgSet(args,9)) ? ((float)args.checkdouble(9)) : 0.0f;
				
				DrawSprite(img.GetTextureID(),quad,quad.w,quad.h,x,y,r,sx,sy,ox,oy);
				return LuaValue.NONE; 
			} 
		});
		
		

		
		/// success = love.graphics.setMode( width, height, fullscreen, vsync, fsaa )
		t.set("setMode", new VarArgFunction() {
			@Override
			public Varargs invoke(Varargs args) {
				bResolutionOverrideActive = true;
				mfResolutionOverrideX = args.checkint(1);
				mfResolutionOverrideY = args.checkint(2);
				// TODO: idea : if w>h and natural w<h , flip 90� ?
				Log("love.graphics.setMode requested resolution = "+mfResolutionOverrideX+" x "+mfResolutionOverrideY);
				return LuaValue.TRUE;
			}
		});
		
		/// width = love.graphics.getWidth( )
		/// Gets the width of the window. 
		t.set("getWidth",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) {
			float w = getScreenW();
			Log("love.graphics.getWidth = "+w);
			return LuaValue.valueOf(w);
			} });
		
		/// height = love.graphics.getHeight( )
		/// Gets the height of the window.
		t.set("getHeight",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) { 
			float h = getScreenH();
			Log("love.graphics.getHeight = "+h);
			return LuaValue.valueOf(h);
			} });
			
			
		
		// ***** ***** ***** ***** ***** global transforms / coordinate system
		
		
		/// love.graphics.scale( sx, sy )
		/// Scaling lasts until love.draw() exits. 
		t.set("scale", new VarArgFunction() {
			@Override
			public Varargs invoke(Varargs args) {
				float sx = (float)args.checkdouble(1);
				float sy = (float)args.checkdouble(2);
				getGL().glScalef(sx,sy,1);
				return LuaValue.NONE;
			}
		});
		
		/// love.graphics.translate( dx, dy )
		/// Translates the coordinate system in two dimensions. 
		t.set("translate", new VarArgFunction() {
			@Override
			public Varargs invoke(Varargs args) {
				float dx = (float)args.checkdouble(1);
				float dy = (float)args.checkdouble(2);
				getGL().glTranslatef(dx,dy,1);
				return LuaValue.NONE;
			}
		});
		
		/// Rotates the coordinate system in two dimensions. 
		/// Calling this function affects all future drawing operations by rotating the coordinate system around the origin by the given amount of radians. This change lasts until love.draw() exits. 
		/// love.graphics.rotate( angle )
		t.set("rotate", new VarArgFunction() {
			@Override
			public Varargs invoke(Varargs args) {
				float a = (float)args.checkdouble(1);
				getGL().glRotatef(LOVE_TODEG(a), 0, 0, 1);
				return LuaValue.NONE;
			}
		});
		
		
		
		/// love.graphics.reset( )
		/// Calling reset makes the current drawing color white, the current background color black, the window title empty and removes any scissor settings. It sets the BlendMode to alpha and ColorMode to modulate. 
		/// It also sets both the point and line drawing modes to smooth and their sizes to 1.0 . Finally, it removes any stipple settings. 
		t.set("reset",				new VarArgFunction() { @Override public Varargs invoke(Varargs args) { 
			setBackgroundColor(new LuanColor(0.0f, 0.0f, 0.0f, 1.0f));
			setForegroundColor(new LuanColor(1f, 1f, 1f, 1f));
			resetTransformMatrix(getGL());
			vm.NotImplemented("love.graphics.reset (lots of settings)");
			// TODO: not yet implemented
			return LuaValue.NONE; 
		} });
		
		
		
		return t;
	}
}

