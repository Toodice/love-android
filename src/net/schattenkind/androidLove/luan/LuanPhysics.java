package net.schattenkind.androidLove.luan;

import net.schattenkind.androidLove.LoveVM;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;




public class LuanPhysics extends LuanBase {
	protected static final String TAG = "LovePhysics";
	
	public LuanPhysics (LoveVM vm) { super(vm); }
	public static final String sMetaName_Body			= "__MetaBody";
	public static final String sMetaName_CircleShape	= "__MetaCircleShape";
	public static final String sMetaName_Contact		= "__MetaContact";
	public static final String sMetaName_Joint			= "__MetaJoint";
	public static final String sMetaName_PolygonShape	= "__MetaPolygonShape";
	public static final String sMetaName_Shape			= "__MetaShape";
	public static final String sMetaName_World			= "__MetaWorld";
	
	public void Log (String s) { LoveVM.LoveLog(TAG, s); }
	
	
	public LuaTable InitLib () {
		LuaTable t = LuaValue.tableOf();
		LuaValue _G = vm.get_G();
		
		_G.set(sMetaName_World			,LuanWorld			.CreateMetaTable(this));
		_G.set(sMetaName_Body			,LuanBody			.CreateMetaTable(this));
		
		_G.set(sMetaName_Shape			,LuanShape			.CreateMetaTable(this));
		_G.set(sMetaName_CircleShape	,LuanCircleShape	.CreateMetaTable(this));
		_G.set(sMetaName_PolygonShape	,LuanPolygonShape	.CreateMetaTable(this));
		
		_G.set(sMetaName_Contact		,LuanContact		.CreateMetaTable(this));
		_G.set(sMetaName_Joint			,LuanJoint			.CreateMetaTable(this));
	
		t.set("newWorld",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) { return LuaValue.userdataOf(new LuanWorld(LuanPhysics.this),vm.get_G().get(sMetaName_World));	} }); 		
		t.set("newBody",			new VarArgFunction() { @Override public Varargs invoke(Varargs args) { return LuaValue.userdataOf(new LuanBody(LuanPhysics.this),vm.get_G().get(sMetaName_Body));	} });
		
		t.set("newRectangleShape",	new VarArgFunction() { @Override public Varargs invoke(Varargs args) { return LuaValue.userdataOf(new LuanShape(LuanPhysics.this),vm.get_G().get(sMetaName_Shape));	} });	
		t.set("newCircleShape",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { return LuaValue.userdataOf(new LuanCircleShape(LuanPhysics.this),vm.get_G().get(sMetaName_CircleShape));	} }); 		
		t.set("newPolygonShape",	new VarArgFunction() { @Override public Varargs invoke(Varargs args) { return LuaValue.userdataOf(new LuanPolygonShape(LuanPhysics.this),vm.get_G().get(sMetaName_PolygonShape));	} });	
		
		t.set("newDistanceJoint",	new VarArgFunction() { @Override public Varargs invoke(Varargs args) { return LuaValue.userdataOf(new LuanJoint(LuanPhysics.this),vm.get_G().get(sMetaName_Joint));	} });		 	
		t.set("newGearJoint",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { return LuaValue.userdataOf(new LuanJoint(LuanPhysics.this),vm.get_G().get(sMetaName_Joint));	} });	 		
		t.set("newMouseJoint",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { return LuaValue.userdataOf(new LuanJoint(LuanPhysics.this),vm.get_G().get(sMetaName_Joint));	} });			 	
		t.set("newPrismaticJoint",	new VarArgFunction() { @Override public Varargs invoke(Varargs args) { return LuaValue.userdataOf(new LuanJoint(LuanPhysics.this),vm.get_G().get(sMetaName_Joint));	} });		 	
		t.set("newPulleyJoint",		new VarArgFunction() { @Override public Varargs invoke(Varargs args) { return LuaValue.userdataOf(new LuanJoint(LuanPhysics.this),vm.get_G().get(sMetaName_Joint));	} });	 	 	
		t.set("newRevoluteJoint",	new VarArgFunction() { @Override public Varargs invoke(Varargs args) { return LuaValue.userdataOf(new LuanJoint(LuanPhysics.this),vm.get_G().get(sMetaName_Joint));	} });		 	
		
		return t;
	}
	
	
	// ***** ***** ***** ***** ***** LuanWorld
	public static class LuanWorld {
		public LuanPhysics phys;
		public LuanWorld (LuanPhysics phys) { this.phys = phys; phys.vm.NotImplemented("LuanWorld:constructor"); }
		public static LuaTable CreateMetaTable (final LuanPhysics phys) {
			LuaTable mt = LuaValue.tableOf();
			LuaTable t = LuaValue.tableOf();
			mt.set("__index",t);
			return mt;
		}
	}
	
	// ***** ***** ***** ***** ***** LuanBody
	
	/// Bodies are objects with velocity and position. 
	public static class LuanBody {
		public LuanPhysics phys;
		public LuanBody (LuanPhysics phys) { this.phys = phys; phys.vm.NotImplemented("LuanBody:constructor"); }
		public static LuaTable CreateMetaTable (final LuanPhysics phys) {
			LuaTable mt = LuaValue.tableOf();
			LuaTable t = LuaValue.tableOf();
			mt.set("__index",t);
			
			t.set("applyForce"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"applyForce"							);	return LuaValue.NONE; } });	
			t.set("applyImpulse"						,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"applyImpulse"						);	return LuaValue.NONE; } });	
			t.set("applyTorque"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"applyTorque"							);	return LuaValue.NONE; } });	
			t.set("destroy"								,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"destroy"								);	return LuaValue.NONE; } });	
			t.set("getAllowSleeping"					,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getAllowSleeping"					);	return LuaValue.NONE; } });	
			t.set("getAngle"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getAngle"							);	return LuaValue.NONE; } });	
			t.set("getAngularDamping"					,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getAngularDamping"					);	return LuaValue.NONE; } });	
			t.set("getAngularVelocity"					,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getAngularVelocity"					);	return LuaValue.NONE; } });	
			t.set("getInertia"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getInertia"							);	return LuaValue.NONE; } });	
			t.set("getLinearDamping"					,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getLinearDamping"					);	return LuaValue.NONE; } });	
			t.set("getLinearVelocity"					,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getLinearVelocity"					);	return LuaValue.NONE; } });	
			t.set("getLinearVelocityFromLocalPoint"		,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getLinearVelocityFromLocalPoint"		);	return LuaValue.NONE; } });	
			t.set("getLinearVelocityFromWorldPoint"		,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getLinearVelocityFromWorldPoint"		);	return LuaValue.NONE; } });	
			t.set("getLocalCenter"						,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getLocalCenter"						);	return LuaValue.NONE; } });	
			t.set("getLocalPoint"						,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getLocalPoint"						);	return LuaValue.NONE; } });	
			t.set("getLocalVector"						,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getLocalVector"						);	return LuaValue.NONE; } });	
			t.set("getMass"								,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getMass"								);	return LuaValue.NONE; } });	
			t.set("getPosition"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getPosition"							);	return LuaValue.NONE; } });	
			t.set("getWorldCenter"						,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getWorldCenter"						);	return LuaValue.NONE; } });	
			t.set("getWorldPoint"						,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getWorldPoint"						);	return LuaValue.NONE; } });	
			t.set("getWorldVector"						,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getWorldVector"						);	return LuaValue.NONE; } });	
			t.set("getX"								,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getX"								);	return LuaValue.NONE; } });	
			t.set("getY"								,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"getY"								);	return LuaValue.NONE; } });	
			t.set("isBullet"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"isBullet"							);	return LuaValue.NONE; } });	
			t.set("isDynamic"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"isDynamic"							);	return LuaValue.NONE; } });	
			t.set("isFrozen"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"isFrozen"							);	return LuaValue.NONE; } });	
			t.set("isSleeping"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"isSleeping"							);	return LuaValue.NONE; } });	
			t.set("isStatic"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"isStatic"							);	return LuaValue.NONE; } });	
			t.set("putToSleep"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"putToSleep"							);	return LuaValue.NONE; } });	
			t.set("setAllowSleeping"					,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"setAllowSleeping"					);	return LuaValue.NONE; } });	
			t.set("setAngle"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"setAngle"							);	return LuaValue.NONE; } });	
			t.set("setAngularDamping"					,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"setAngularDamping"					);	return LuaValue.NONE; } });	
			t.set("setAngularVelocity"					,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"setAngularVelocity"					);	return LuaValue.NONE; } });	
			t.set("setBullet"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"setBullet"							);	return LuaValue.NONE; } });	
			t.set("setFixedRotation"					,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"setFixedRotation"					);	return LuaValue.NONE; } });	
			t.set("setInertia"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"setInertia"							);	return LuaValue.NONE; } });	
			t.set("setLinearDamping"					,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"setLinearDamping"					);	return LuaValue.NONE; } });	
			t.set("setLinearVelocity"					,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"setLinearVelocity"					);	return LuaValue.NONE; } });	
			t.set("setMass"								,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"setMass"								);	return LuaValue.NONE; } });	
			t.set("setMassFromShapes"					,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"setMassFromShapes"					);	return LuaValue.NONE; } });	
			t.set("setPosition"							,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"setPosition"							);	return LuaValue.NONE; } });	
			t.set("setX"								,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"setX"								);	return LuaValue.NONE; } });	
			t.set("setY"								,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"setY"								);	return LuaValue.NONE; } });	
			t.set("wakeUp"								,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"wakeUp"								);	return LuaValue.NONE; } });	
			t.set("type"								,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"type"								);	return LuaValue.NONE; } });	
			t.set("typeOf"								,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Body:"+"typeOf"								);	return LuaValue.NONE; } });	

			return mt;
		}
	}
	// ***** ***** ***** ***** ***** LuanShape
	public static class LuanShape {
		public LuanPhysics phys;
		public LuanShape (LuanPhysics phys) { this.phys = phys; phys.vm.NotImplemented("LuanShape:constructor"); }
		
		
		public static void AddMethodsToTable (final LuanPhysics phys,LuaTable t) {
			t.set("type"			,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"type"			);	return LuaValue.NONE; } });	
			t.set("typeOf"			,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"typeOf"			);	return LuaValue.NONE; } });	
			t.set("destroy"			,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"destroy"			);	return LuaValue.NONE; } });	
			t.set("getBody"			,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"getBody"			);	return LuaValue.NONE; } });	
			t.set("getBoundingBox"	,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"getBoundingBox"	);	return LuaValue.NONE; } });	
			t.set("getCategory"		,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"getCategory"		);	return LuaValue.NONE; } });	
			t.set("getCategoryBits"	,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"getCategoryBits"	);	return LuaValue.NONE; } });	
			t.set("getData"			,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"getData"			);	return LuaValue.NONE; } });	
			t.set("getDensity"		,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"getDensity"		);	return LuaValue.NONE; } });	
			t.set("getFilterData"	,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"getFilterData"	);	return LuaValue.NONE; } });	
			t.set("getFriction"		,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"getFriction"		);	return LuaValue.NONE; } });	
			t.set("getMask"			,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"getMask"			);	return LuaValue.NONE; } });	
			t.set("getRestitution"	,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"getRestitution"	);	return LuaValue.NONE; } });	
			t.set("getType"			,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"getType"			);	return LuaValue.NONE; } });	
			t.set("isSensor"		,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"isSensor"		);	return LuaValue.NONE; } });	
			t.set("setCategory"		,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"setCategory"		);	return LuaValue.NONE; } });	
			t.set("setData"			,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"setData"			);	return LuaValue.NONE; } });	
			t.set("setDensity"		,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"setDensity"		);	return LuaValue.NONE; } });	
			t.set("setFilterData"	,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"setFilterData"	);	return LuaValue.NONE; } });	
			t.set("setFriction"		,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"setFriction"		);	return LuaValue.NONE; } });	
			t.set("setMask"			,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"setMask"			);	return LuaValue.NONE; } });	
			t.set("setRestitution"	,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"setRestitution"	);	return LuaValue.NONE; } });	
			t.set("setSensor"		,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"setSensor"		);	return LuaValue.NONE; } });	
			t.set("testPoint"		,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"testPoint"		);	return LuaValue.NONE; } });	
			t.set("testSegment"		,new VarArgFunction() { @Override public Varargs invoke(Varargs args) { phys.vm.NotImplemented("Shape:"+"testSegment"		);	return LuaValue.NONE; } });	
		}
		
		public static LuaTable CreateMetaTable (final LuanPhysics phys) {
			LuaTable mt = LuaValue.tableOf();
			LuaTable t = LuaValue.tableOf();
			mt.set("__index",t);
			AddMethodsToTable(phys,t);
			return mt;
		}
	}
	// ***** ***** ***** ***** ***** LuanCircleShape
	public static class LuanCircleShape {
		public LuanPhysics phys;
		public LuanCircleShape (LuanPhysics phys) { this.phys = phys; phys.vm.NotImplemented("LuanCircleShape:constructor"); }
		public static LuaTable CreateMetaTable (final LuanPhysics phys) {
			LuaTable mt = LuaValue.tableOf();
			LuaTable t = LuaValue.tableOf();
			mt.set("__index",t);
			LuanShape.AddMethodsToTable(phys,t);
			return mt;
		}
	}
	// ***** ***** ***** ***** ***** LuanPolygonShape
	public static class LuanPolygonShape {
		public LuanPhysics phys;
		public LuanPolygonShape (LuanPhysics phys) { this.phys = phys; phys.vm.NotImplemented("LuanPolygonShape:constructor"); }
		public static LuaTable CreateMetaTable (final LuanPhysics phys) {
			LuaTable mt = LuaValue.tableOf();
			LuaTable t = LuaValue.tableOf();
			mt.set("__index",t);
			LuanShape.AddMethodsToTable(phys,t);
			return mt;
		}
	}
	// ***** ***** ***** ***** ***** LuanContact
	public static class LuanContact {
		public LuanPhysics phys;
		public LuanContact (LuanPhysics phys) { this.phys = phys; phys.vm.NotImplemented("LuanContact:constructor"); }
		public static LuaTable CreateMetaTable (final LuanPhysics phys) {
			LuaTable mt = LuaValue.tableOf();
			LuaTable t = LuaValue.tableOf();
			mt.set("__index",t);
			return mt;
		}
	}
	// ***** ***** ***** ***** ***** LuanJoint
	public static class LuanJoint {
		public LuanPhysics phys;
		public LuanJoint (LuanPhysics phys) { this.phys = phys; phys.vm.NotImplemented("LuanJoint:constructor"); }
		public static LuaTable CreateMetaTable (final LuanPhysics phys) {
			LuaTable mt = LuaValue.tableOf();
			LuaTable t = LuaValue.tableOf();
			mt.set("__index",t);
			return mt;
		}
	}
}
