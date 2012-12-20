/*
 * This file is part of Streamland.
 *
 * Copyright (c) 2012-2012, Spout LLC <http://www.spout.org/>
 * Streamland is licensed under the Spout License Version 1.
 *
 * Streamland is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * Streamland is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://spout.in/licensev1> for the full license, including
 * the MIT license.
 */
package org.spout.droplet.streamland;

import org.spout.api.Engine;
import org.spout.api.Spout;
import org.spout.api.geo.World;
import org.spout.api.geo.discrete.Point;
import org.spout.api.geo.discrete.Transform;
import org.spout.api.math.Quaternion;
import org.spout.api.math.Vector3;
import org.spout.api.plugin.CommonPlugin;
import org.spout.droplet.streamland.generator.StreamlandFlatGenerator;


public class StreamlandPlugin extends CommonPlugin {
	Engine engine;
	@Override
	public void onEnable() {
		engine = Spout.getEngine();
		
		
		World mainWorld = engine.loadWorld("streamland", new StreamlandFlatGenerator(10)); 
		
		Spout.getEngine().setDefaultWorld(mainWorld);
		if (mainWorld.getAge() <= 0) {
			mainWorld.setSpawnPoint(new Transform(new Point(mainWorld, 1, 3, 1), Quaternion.IDENTITY, Vector3.ONE));
		}
		
	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

}