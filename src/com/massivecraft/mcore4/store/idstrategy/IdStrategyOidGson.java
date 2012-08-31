package com.massivecraft.mcore4.store.idstrategy;

import com.massivecraft.mcore4.lib.bson.types.ObjectId;
import com.massivecraft.mcore4.store.CollInterface;

public class IdStrategyOidGson extends IdStrategyAbstract<ObjectId, String>
{
	// -------------------------------------------- //
	// IMPLEMENTATION
	// -------------------------------------------- //
	
	@Override public String localToRemote(Object local) { return ((ObjectId)local).toStringBabble(); }
	@Override public ObjectId remoteToLocal(Object remote) { return ObjectId.massageToObjectId((String)remote); }
	
	@Override
	public ObjectId generateAttempt(CollInterface<?, ObjectId> coll)
	{
		return ObjectId.get();
	}
	
	//----------------------------------------------//
	// CONSTRUCTORS
	//----------------------------------------------//
	
	private IdStrategyOidGson()
	{
		super("oid", ObjectId.class, String.class);
	}
	
	// -------------------------------------------- //
	// INSTANCE
	// -------------------------------------------- //
	
	protected static IdStrategyOidGson instance = new IdStrategyOidGson();
	public static IdStrategyOidGson get()
	{
		return instance;
	}
}
