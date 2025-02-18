/*
 * Designed and developed by 2018 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.androidveildemo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.skydoves.androidveil.VeiledItemOnClickListener
import com.skydoves.androidveildemo.databinding.ActivitySecondBinding
import com.skydoves.androidveildemo.profile.ListItemUtils
import com.skydoves.androidveildemo.profile.Profile
import com.skydoves.androidveildemo.profile.ProfileAdapter

class SecondActivity :
  AppCompatActivity(),
  VeiledItemOnClickListener,
  ProfileAdapter.ProfileViewHolder.Delegate {

  private val adapter = ProfileAdapter(this)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = ActivitySecondBinding.inflate(layoutInflater)
    setContentView(binding.root)

    // sets VeilRecyclerView's properties
    binding.veilFrameView.run {
      setVeilLayout(R.layout.item_preview, this@SecondActivity)
      setAdapter(adapter)
      setLayoutManager(GridLayoutManager(this@SecondActivity, 2))
      addVeiledItems(12)
    }

    // add profile times to adapter
    adapter.addProfiles(ListItemUtils.getProfiles(this))
  }

  /** OnItemClickListener by Veiled Item */
  override fun onItemClicked(pos: Int) {
    Toast.makeText(this, getString(R.string.msg_loading), Toast.LENGTH_SHORT).show()
  }

  /** OnItemClickListener by User Item */
  override fun onItemClickListener(profile: Profile) {
    startActivity(Intent(this, DetailActivity::class.java))
  }
}
