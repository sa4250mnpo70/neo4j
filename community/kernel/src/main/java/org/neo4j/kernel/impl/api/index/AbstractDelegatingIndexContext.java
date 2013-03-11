/**
 * Copyright (c) 2002-2013 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.kernel.impl.api.index;

import java.util.concurrent.Future;

import org.neo4j.kernel.api.index.InternalIndexState;
import org.neo4j.kernel.api.index.NodePropertyUpdate;

public abstract class AbstractDelegatingIndexContext implements IndexContext
{
    protected abstract IndexContext getDelegate();

    @Override
    public void create()
    {
        getDelegate().create();
    }
    
    @Override
    public void update( Iterable<NodePropertyUpdate> updates )
    {
        getDelegate().update( updates );
    }

    @Override
    public Future<Void> drop()
    {
        return getDelegate().drop();
    }

    @Override
    public InternalIndexState getState()
    {
        return getDelegate().getState();
    }

    @Override
    public IndexDescriptor getDescriptor()
    {
        return getDelegate().getDescriptor();
    }

    @Override
    public void force()
    {
        getDelegate().force();
    }
    
    @Override
    public Future<Void> close()
    {
        return getDelegate().close();
    }
}