/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.eucalypto.eucalyptapp.trivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import de.eucalypto.eucalyptapp.databinding.FragmentTriviaGameOverBinding

class GameOverFragment : Fragment() {

    private val args: GameOverFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentTriviaGameOverBinding.inflate(inflater, container, false)

        binding.tryAgainButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(GameOverFragmentDirections.actionTriviaStartNewGame())
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(
            context,
            "Correct Answers: ${args.numCorrect} out of ${args.numQuestions} questions.",
            Toast.LENGTH_LONG
        ).show()
    }
}
